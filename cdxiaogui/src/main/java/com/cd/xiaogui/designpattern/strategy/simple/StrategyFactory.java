package com.cd.xiaogui.designpattern.strategy.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 1:41 下午
 */
public class StrategyFactory {
    private static Map<String, AbsStrategyService> map = new HashMap<>();
    static{
        map.put("A", new AStrategy());
        map.put("B", new BStrategy());
    }
    public static AbsStrategyService getStrategy(String key){
        return map.get(key);
    }

    public static void main(String[] args) {
        StrategyFactory.getStrategy("B").doJob();
    }
}
