package com.klaus.iv.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 陈龙:
 * 一个数组，一个k，判断这个数组是否满足n个子数组
 *
 * 陈龙:
 * 子数组是等差数列，差值为1
 *
 * 陈龙:
 * 子数组长度为k
 *
 * 陈龙:
 * 数组每个数只能用一次
 */
@Slf4j
public class HuaweiInterview {


    private static boolean judge(Integer[] nums, int k) {
        if (nums == null || nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int n = k;
            int a = nums[i];
            if (map.get(a).equals(0)) {
                continue;
            }
            while (n-- > 0) {
                if (!map.containsKey(a)) {
                    return false;
                } else {
                    Integer value = map.get(a);
                    if (value.equals(0))
                    {
                        return false;
                    }
                    map.put(a, value - 1);
                }
                ++a;
            }

        }
        log.info("map is :{}", map);
        return true;
    }


    public static void main(String[] args) {
        List<Integer> data =  Arrays.asList(1,2,2,3,3,4,4,5);
        judge(data.toArray(new Integer[8]), 2);
    }
}
