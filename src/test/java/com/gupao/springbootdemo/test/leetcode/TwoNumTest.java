package com.gupao.springbootdemo.test.leetcode;

import java.util.HashMap;

/**
 * 功能描述:
 *
 * @Author: zhouzhou
 * @Date: 2020/11/10$ 15:38$
 */
public class TwoNumTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 4, 5, 6, 32, 7765, 44, 4, 44, 433};
        int target = 439;
        int[] ints = twoSum(arr, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int result = target - num;
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(num, i);
        }

        return null;
    }
}
