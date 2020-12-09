package com.gupao.springbootdemo.test.leetcode;

/**
 * 功能描述:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 输入: 121
 * 输出: true
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @Author: zhouzhou
 * @Date: 2020/11/10$ 15:38$
 */
public class PalindromeNumberTest {

    public static void main(String[] args) {
        int i = 0;
        System.out.println(isPalindrome(i));

    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        // 一共是几位数
        int length = String.valueOf(x).length();
        if (length < 2) {
            return false;
        }
        for (int i = 0; i < length / 2; i++) {
            int tail = (int) (x % (Math.pow(10, i + 1))) / (int) Math.pow(10, i);
            int pre = (x / (int)Math.pow(10,length - i - 1)) % 10;
            if (tail != pre) {
                return false;
            }
        }

        return true;

    }

}
