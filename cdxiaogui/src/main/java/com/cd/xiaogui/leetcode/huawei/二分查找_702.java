package com.cd.xiaogui.leetcode.huawei;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/*
   给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
   示例 1:
   输入: nums = [-1,0,3,5,9,12], target = 9
   输出: 4
   解释: 9 出现在 nums 中并且下标为 4

   示例 2:
   输入: nums = [-1,0,3,5,9,12], target = 2
   输出: -1
   解释: 2 不存在 nums 中因此返回 -1
   提示：
   你可以假设 nums 中的所有元素是不重复的。
   n 将在 [1, 10000]之间。
   nums 的每个元素都将在 [-9999, 9999]之间。
 *
 */
@Slf4j
public class 二分查找_702 {
    @Test
    public void test(){
        int [] art = new int[]{1,2,3,4,5,6,7};
        System.out.println(this.search2(art, 0));
        System.out.println(this.search(art, 2));
    }
    public static int search(int[] nums, int target) {

        int x=0,y=nums.length-1;
        while(x<=y){
            int mid = (x+y) % 2==0? (x+y)/2 : (x+y)/2+1 ;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                y=mid-1;
            }else {
                x = mid+1;
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {

        int x=0,y=nums.length-1;
        int COUNT = 0;
        while(x<=y){
            System.out.println("执行第{}轮");
            log.info("执行第{}轮", (++COUNT));

            if(target == nums[(x+y) % 2==0? (x+y)/2 : (x+y)/2+1 ]){
                return (x+y) % 2==0? (x+y)/2 : (x+y)/2+1;
            }else if(target < nums[(x+y) % 2==0? (x+y)/2 : (x+y)/2+1 ]){
                y=((x+y) % 2==0? (x+y)/2 : (x+y)/2+1)-1;
            }else {
                x = ((x+y) % 2==0? (x+y)/2 : (x+y)/2+1)+1;
            }
        }
        return -1;
    }
}
