package com.cd.xiaogui.designpattern;

/**
 * 处理者抽象
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 10:29 上午
 */
public abstract class JobHandle<S, R> {

    JobHandle next;

    public JobHandle getNext() {
        return next;
    }

    public void setNext(JobHandle next) {
        this.next = next;
    }

    public abstract S handle(R r);
}
