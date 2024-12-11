package com.cd.xiaogui;

import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author sunyawei3
 * 创建时间 2023/2/2 6:28 下午
 */
public class TestTemp001 {
//    一共三道题，
//    t1 删除二叉树给定层节点，然后返回剩下的二叉树，
//    t2 对二叉树对应节点进行异或操作，
//    t3 求出现 k 次的字符次数。
//
//    难度我认为是 t1>t2>t3
//
//    t3 直接哈希表秒，t2 我直接模拟的，然后 t1 想了一会，我是层序存下来，然后把对应层删掉，再扫描，并判断父节点是不是空或者删除节点，是就入数组。
//
//    作者：AC 自动机
//    链接：https://leetcode.cn/circle/discuss/tXxA6d/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public static void main(String[] args) {
        List li = new ArrayList<>();
        li.add(1);

        System.out.println(li);
        li.add(0,li);
    }

}
