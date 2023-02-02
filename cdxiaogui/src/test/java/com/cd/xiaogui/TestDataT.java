package com.cd.xiaogui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2022/10/19 6:22 下午
 */
public class TestDataT {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'");
        System.out.println(sdf.format(date));
        date = new Date();
        System.out.println(sdf.format(date));

        date = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(sdf2.format(date));

        AtomicInteger atomicInteger = new AtomicInteger();

        classes.com.cd.xiaogui.lomboktest.A a = new classes.com.cd.xiaogui.lomboktest.A("aaa");
        System.out.println(a.toString());
    }
}
