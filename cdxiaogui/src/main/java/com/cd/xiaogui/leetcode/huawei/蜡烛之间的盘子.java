package com.cd.xiaogui.leetcode.huawei;


import com.alibaba.fastjson.JSON;

/*
给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。

请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。

https://leetcode-cn.com/problems/plates-between-candles/
输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
输出：[9,0,0,0,0]
解释：
- queries[0] 有 9 个盘子在蜡烛之间。
- 另一个查询没有盘子在蜡烛之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plates-between-candles
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 蜡烛之间的盘子 {


    public static void main(String[] args) {
        String s1 = "***|**|*****|**||**|*";
        int[][] ints1 = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        String s2 = "**|**|***|";
        int[][] ints2 = new int [][]{{2,5},{5,9}};

        System.out.println(JSON.toJSONString(platesBetweenCandles(s1, ints1)));;
        System.out.println("=======================");
        System.out.println(JSON.toJSONString(platesBetweenCandles(s2, ints2)));;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int [] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String data = s.substring(queries[i][0], queries[i][1]+1);
            System.out.println("data = " + data);
            if(data.indexOf("|")>-1 && data.indexOf("|")>-1){
                res[i] = data.substring(data.indexOf("|"), data.lastIndexOf("|")).replace("|","").length();
            }else {
                res[i]=0;
            }
        }
        return res;
    }
    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        int [] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String data = s.substring(queries[i][0], queries[i][1]+1);
            System.out.println("data = " + data);
            if(data.indexOf("|")>-1 && data.indexOf("|")>-1){
                res[i] = data.substring(data.indexOf("|"), data.lastIndexOf("|")).replace("|","").length();
            }else {
                res[i]=0;
            }
        }
        return res;
    }
}
