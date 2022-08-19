package com.cd.xiaogui;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 延迟处理
 *
 * @author sunyawei3
 * 创建时间 2022/7/25 1:59 下午
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

                System.out.println(sf.format(new Date()));
            }
        }, 2, TimeUnit.SECONDS);
        System.out.println("end");
    }


    @Test
    public void tt(){
        Map<String, String> m = new HashMap<>();
        m.put(null,"1");
        m.put("2","2");
        System.out.println(m.get(null));
    }
}
