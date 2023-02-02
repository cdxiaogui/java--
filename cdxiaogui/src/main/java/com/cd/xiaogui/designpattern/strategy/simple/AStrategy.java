package com.cd.xiaogui.designpattern.strategy.simple;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 11:16 上午
 */
public class AStrategy extends AbsJob implements AbsStrategyService {
    @Override
    public void handle() {
        System.out.println("A 开始卷");
    }

    @Override
    public void doJob() {
        System.out.println("A 开始花样卷");
    }
}
