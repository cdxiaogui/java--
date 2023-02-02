package com.cd.xiaogui.designpattern.strategy.simple;

/**
 * 简单工厂
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 11:19 上午
 */
public class SimpleFactory {

    public AbsJob getStrategy(String flag){
        if ("A".equals(flag)){
            return new AStrategy();
        }else if ("B".equals(flag)){
            return new BStrategy();
        }else return null;
    }

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        factory.getStrategy("B").handle();
        factory.getStrategy("A").handle();
    }
}
