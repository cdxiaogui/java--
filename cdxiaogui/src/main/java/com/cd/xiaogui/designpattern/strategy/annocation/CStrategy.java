package com.cd.xiaogui.designpattern.strategy.annocation;

import com.cd.xiaogui.designpattern.strategy.simple.AbsStrategyService;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 1:50 下午
 */
@StrategyANO(routerStr = "D")
public class CStrategy implements AbsStrategyService {
    @Override
    public void doJob() {
        System.out.println("C 开始花样卷");
    }
}
