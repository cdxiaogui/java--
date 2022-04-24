package com.cd.xiaogui.tool;

import org.junit.jupiter.api.Test;

public class 十进制转换R进制 {


    /**
     *
     * @param num 十进制数据
     * @param R  转换成R进制
     * @return
     */
    public static String convertToBaseR(int num,  int R) {
        if (num == 0) return "0";
        StringBuffer sb = new StringBuffer();
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0){
            sb.insert(0, num % R);
            num /= R;
        }
        return flag?sb.insert(0, "-").toString():sb.toString();
    }

    @Test
    public void test_10_2(){
        // 十进制转换2 3 进制
        System.out.println(convertToBaseR(4,2));
        System.out.println(convertToBaseR(4,3));
    }
}
