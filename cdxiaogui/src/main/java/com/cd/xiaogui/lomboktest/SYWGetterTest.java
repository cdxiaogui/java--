package com.cd.xiaogui.lomboktest;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/10/26 4:56 下午
 */

@SYWGetter
@SYWSetter
//@Data
public class SYWGetterTest {
     String a;
     String b;

    public static void main(String[] args) {
//        SYWGetterTest test = new SYWGetterTest("");
////        test.setA("1");
//        System.out.println(JSON.toJSONString(test));
//
//        Map<Integer,SYWGetterTest> map = new HashMap<>();
//        map.put(1, new SYWGetterTest("a"));
//        map.put(2, new SYWGetterTest("b"));
//        map.put(3, new SYWGetterTest("c"));
//        map.put(4, new SYWGetterTest("d"));
//        Map<Integer,String>  res = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, ss-> ss.getValue().getB()));
//        Map<Integer,String>  ress = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, ss-> (ss.getValue().getB().equals("")? ss.getValue().getB():"cd")));


    }

//    public void setB(String b) {
//        this.b = b;
//    }
//
//    public String getB() {
//        return b;
//    }
//
//    public SYWGetterTest(String b) {
//        this.b = b;
//    }
}
