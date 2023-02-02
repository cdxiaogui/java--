package com.cd.xiaogui;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExcelTEST {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.submit(new A(new Date(),10));
        scheduledExecutorService.submit(new A(new Date(), 11));
//        scheduledExecutorService.schedule(new A(new Date(), 20), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.schedule(new A(new Date(), 21), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.schedule(new A(new Date(), 22), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.schedule(new A(new Date(), 23), 3, TimeUnit.SECONDS);

    }

}

@Slf4j
@Data
class A implements Runnable{
    Date date;
    int task;
    A(Date date, int task){
        this.date=date;
        this.task = task;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(new SimpleDateFormat("HH-mm-ss-sss   ").format(date) + "task=" + task + "   " + Thread.currentThread().getName());
        }catch (Exception e){
            log.error("error");
        }
    }
}