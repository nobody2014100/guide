package com.klaus.iv.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 */
public class Solution {
    public static int singleNumber(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1; i++) {
            count = 0;
            for(int j= i+1; j< nums.length; j++) {
                if(nums[i] - nums[j] == 0) {
                    continue;
                }
                count++;

                System.out.println(String.format("count is %s , length is %s", count, nums.length-i));
                if(count == (nums.length-i)) {
                    return nums[i];

                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2,2,1};
        System.out.println(singleNumber(data));
    }
}