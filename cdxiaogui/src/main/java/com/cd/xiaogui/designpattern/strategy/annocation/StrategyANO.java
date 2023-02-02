package com.cd.xiaogui.designpattern.strategy.annocation;

import java.lang.annotation.*;

/**
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 1:46 下午
 */
@Target( ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StrategyANO {
    String routerStr()  default "A";
}
