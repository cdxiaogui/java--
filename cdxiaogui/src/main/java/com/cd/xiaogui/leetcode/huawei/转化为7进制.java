package com.cd.xiaogui.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/*
给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。

示例 1:

输入: num = 100
输出: "202"
示例 2:

输入: num = -7
输出: "-10"

提示：

-10 7<= num <= 10 7
链接：https://leetcode-cn.com/problems/base-7
 */
@Slf4j

public class 转化为7进制 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7_2(100));
    }
    public static String convertToBase7(int num) {
        if (num == 0) return "0";
        Stack s = new Stack();
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0){
            if(num % 7 == 0){
                s.push(0);
            }else{
                s.push(num % 7);
            }
            num = num/7;
        }
        String str = "";
        while (!s.isEmpty()){
            str+=s.pop();
        }
        if(flag) return "-" +str;
        return str;
    }

    public static String convertToBase7_2(int num) {
        if (num == 0) return "0";
        StringBuffer sb = new StringBuffer();
        boolean flag = num < 0;
        num = Math.abs(num);
        while (num != 0){
            sb.insert(0, num % 7);
            num /= 7;
        }
        if(flag) return sb.insert(0, "-").toString();
        return sb.toString();
    }
/*
https://leetcode-cn.com/problems/base-7/solution/qi-jin-zhi-shu-by-leetcode-solution-cl2v/
*/

}
