package com.cd.xiaogui.designpattern;

/**
 * 责任链模式
 *
 * @author sunyawei3
 * 创建时间 2022/11/8 10:25 上午
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        Job001Handler job001Handler = new Job001Handler();
        Job002Handler job002Handler = new Job002Handler();
        job001Handler.setNext(job002Handler);
        System.out.println(job001Handler.handle(2));
    }

}

