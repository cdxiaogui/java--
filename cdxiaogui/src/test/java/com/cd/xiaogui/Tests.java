package com.cd.xiaogui;

import java.util.Collections;

public class Tests {
    public static void main(String[] args) {
        System.out.println(null instanceof Integer );

        Integer integer = (Integer) null;
        System.out.println(integer);
        System.out.println(Collections.singletonList(123));
        System.out.println(testBoolean(null));
        String aa = "123";
        ttt(aa);
        System.out.println(aa);
    }

    private static boolean testBoolean(Boolean b){
        return b;
    }

    public static boolean ttt(String a){
        a = "1";
        return false;
    }
}
