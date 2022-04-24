package com.cd.xiaogui.tool;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 流程处理器
 * author sunyawei
 * @param <R>
 */
public class ProcessCaller<R> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCaller.class);

    private Logger logger;

    private Object processObject;

    private boolean processBranch;

    private boolean log = true;

    private boolean debugEnabled = log && LOGGER.isDebugEnabled();

    private int step;

    private transient Supplier<ProcessCaller<R>> subProcessBuild = () -> {
        ProcessCaller<R> subProcess = ProcessCaller.of();
        subProcess.step = this.step;
        subProcess.processObject = this.processObject;
        subProcess.processBranch = this.processBranch;
        return subProcess;
    };

    private ProcessCaller() {
        this.logger = LOGGER;
    }

    public ProcessCaller(R r) {
        this.logger = LOGGER;
        this.processObject = r;
    }

    public <S> ProcessCaller<S> reset(S s, Object... logParams) {
        logger.info("【{}】开始执行process重置流程, 入参:【{}】", this.step, JSON.toJSONString(getLogParams(s, logParams)));
        this.processObject = s;
        logger.info("【{}】process call重置流程完成, 结果:【{}】", this.step, JSON.toJSONString(this.processObject));
        return (ProcessCaller<S>) addStep();
    }

    public static <R> ProcessCaller<R> of(String key, R r) {
        ProcessCaller process = new ProcessCaller();
        LOGGER.info("{}【{}】开始执行process赋值流程, 入参:【{}】", key, process.step, JSON.toJSONString(r));
        if (null != r) {
            process.processObject = r;
        }
        return process.addStep();
    }

    public static <R> ProcessCaller<R> of(R r, Object... logParams) {
        ProcessCaller process = new ProcessCaller();
        LOGGER.info("【{}】开始执行process赋值流程, 入参:【{}】", process.step, JSON.toJSONString(getLogParams(r,logParams)));
        if (null != r) {
            process.processObject = r;
        }
        return process.addStep();
    }

    public static <R> ProcessCaller<R> of(R r, Logger logger, Object... logParams) {
        ProcessCaller process = new ProcessCaller();
        process.logger = logger;
        process.debugEnabled = logger.isDebugEnabled();
        logger.info("【{}】开始执行process赋值流程, 入参:【{}】", process.step, JSON.toJSONString(getLogParams(r,logParams)));
        if (null != r) {
            process.processObject = r;
        }
        return process.addStep();
    }

    public static <R> ProcessCaller<R> of(Class<R> clazz) {
        ProcessCaller process = new ProcessCaller();
        LOGGER.info("【{}】执行process赋值流程, 无入参", process.step);
        return process.addStep();
    }


    public static <R> ProcessCaller<R> of() {
        ProcessCaller process = new ProcessCaller();
        LOGGER.info("【{}】执行process赋值流程, 无入参", process.step);
        return process.addStep();
    }

    public ProcessCaller<R> debug() {
        this.debugEnabled = true;
        return this;
    }

    public ProcessCaller<R> log(Logger logger) {
        this.logger = logger;
        this.debugEnabled = logger.isDebugEnabled();
        return this;
    }

    public ProcessCaller<R> log(boolean log) {
        this.log = log;
        this.debugEnabled = log && LOGGER.isDebugEnabled();
        return this;
    }


    public ProcessCaller<R> predicate(Predicate<R> predicate) {
        processBranch = predicate.test((R) processObject);
        return this;
    }

    public <S> ProcessCaller<R> predicate(S s, Predicate<S> predicate) {
        this.processBranch = predicate.test(s);
        return this;
    }

    public <S> ProcessCaller<S> branch(Function<ProcessCaller<R>, ProcessCaller<S>> ifTrueProcess, Function<ProcessCaller<R>, ProcessCaller<S>> ifFalseProcess) {
        if(processBranch) {
            if (ifTrueProcess == null) {
                return (ProcessCaller<S>) this;
            }
            return ifTrue(ifTrueProcess);
        }
        if (ifFalseProcess == null) {
            return (ProcessCaller<S>) this;
        }
        return ifFalse(ifFalseProcess);
    }

    public <S> ProcessCaller<S> ifTrue(Function<ProcessCaller<R>, ProcessCaller<S>> func) {
        if (processBranch) {
            ProcessCaller<S> p = func.apply(subProcessBuild.get());
            this.step = p.step;
            this.processObject = p.processObject;
            return p;
        }
        return (ProcessCaller<S>) this;
    }

    public <S, D> ProcessCaller<R> ifTrue(Supplier<ProcessCaller<D>> func, ProcessCaller<D> process) {
        process.processBranch = this.processBranch;
        if (processBranch) {
            process.step = this.step;
            process.processObject = this.processObject;
            ProcessCaller<D> p = func.get();
            this.step = process.step;
            this.processObject = process.processObject;
            return (ProcessCaller<R>) p;
        }
        return this;
    }

    private  <S> ProcessCaller<S> ifFalse(Function<ProcessCaller<R>, ProcessCaller<S>> func) {
        if (!processBranch) {
            ProcessCaller<S> p = func.apply(subProcessBuild.get());
            this.step = p.step;
            this.processObject = p.processObject;
            return p;
        }
        return (ProcessCaller<S>) this;
    }

    public <S, D> ProcessCaller<S> ifFalse(Supplier<ProcessCaller<S>> func, ProcessCaller<D> process) {
        process.processBranch = this.processBranch;
        if (!processBranch) {
            process.step = this.step;
            process.processObject = this.processObject;
            ProcessCaller<S> p = func.get();
            this.step = process.step;
            this.processObject = process.processObject;
            return p;
        }
        return (ProcessCaller<S>) this;
    }


    public <S extends Throwable> ProcessCaller<R> ifFalseThrow(Supplier<? extends S> exceptionSupplier) throws S {
        if (!processBranch && exceptionSupplier != null) {
            logger.info("【{}】process 手工拋出異常", step);
            throw exceptionSupplier.get();
        }
        return this.addStep();
    }

    public <S> S ifFalseReturn(S s) {
        return s;
    }

    /**
     *
     * @param func
     * @param logParams
     * @param <S>
     * @return
     */
    public <S> ProcessCaller<S> map(Function<R, S> func, Object... logParams) {
        if (debugEnabled) {
            logger.info("【{}】开始执行process后置处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        }
        if (null != func) {
            this.processObject = func.apply((R) this.processObject);
        }
        if (debugEnabled) {
            logger.info("【{}】process后置处理完成, 结果:【{}】", step, JSON.toJSONString(processObject));
        }
        return (ProcessCaller<S>) this.addStep();
    }


    public <S> ProcessCaller<R> accept(S s, Consumer<S> func, Object... logParams) {
        if (debugEnabled) logger.info("【{}】开始执行process后置处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        if (null != func) {
            func.accept(s);
        }
        if (debugEnabled) logger.info("【{}】process后置处理完成, 结果:【{}】", step, JSON.toJSONString(processObject));
        return this.addStep();
    }

    /**
     * 只管消费如需其他处理
     * @param func
     * @param logParams
     * @return
     */
    public ProcessCaller<R> accept(Consumer<R> func, Object... logParams) {
        if (debugEnabled) logger.info("【{}】开始执行process后置处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        if (null != func) {
            func.accept((R) processObject);
        }
        if (debugEnabled) logger.info("【{}】process后置处理完成, 结果:【{}】", step, JSON.toJSONString(processObject));
        return this.addStep();
    }

    public <O> ProcessCaller<R> outMap(O out, Function<R, O> func, Object... logParams) {
        if (debugEnabled) logger.info("【{}】开始执行process后置处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        O apply = null;
        if (null != func) {
            apply = func.apply((R) processObject);
            BeanUtils.copyProperties(apply, out);
        }
        if (log) {
            logger.info("【{}】process后置处理完成, 结果:【{},{}】", step, JSON.toJSONString(apply), JSON.toJSONString(out));
        }
        return this.addStep();
    }

    public <S> S get(Function<R, S> func, Object... logParams) {
        if (debugEnabled) logger.debug("【{}】开始执行process完成处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        S s = null;
        if (null != func) {
            s = func.apply((R) processObject);
        }
        if (log) {
            logger.info("【{}】process完成处理结束, 结果:【{}】", step, JSON.toJSONString(s));
        }
        return s;
    }

    public R get() {
        if (log) {
            logger.info("【{}】process完成处理结束, 结果:【{}】", step, JSON.toJSONString(processObject));
        }
        return (R) processObject;
    }

    public <S> S get(Supplier<S> func, Object... logParams) {
        if (debugEnabled) logger.debug("【{}】开始执行process完成处理, 入参:【{}】", step, JSON.toJSONString(getLogParams(processObject, logParams)));
        S s = null;
        if (null != func) {
            s = func.get();
        }
        if (log) {
            logger.info("【{}】process完成处理结束, 结果:【{}】", step, JSON.toJSONString(s));
        }
        return s;
    }

    private ProcessCaller<R> addStep() {
        step++;
        return this;
    }

    private static List<Object> getLogParams(Object log, Object[] logs) {
        List<Object> logList = new ArrayList(4);
        if (logs != null && logs.length > 0) {
            logList.addAll(Arrays.asList(logs));
        }
        logList.add(log);
        return logList;
    }
}
