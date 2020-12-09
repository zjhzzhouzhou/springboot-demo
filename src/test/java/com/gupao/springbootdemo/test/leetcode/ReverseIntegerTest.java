package com.gupao.springbootdemo.test.leetcode;

/**
 * 功能描述:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 输入: 123
 * 输出: 321
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 输入: 120
 * 输出: 21
 *
 * @Author: zhouzhou
 * @Date: 2020/11/10$ 15:38$
 */
public class ReverseIntegerTest {

    public static void main(String[] args) {
        int i = -128480;
        int reverse = fastReverse(i);
        System.out.println(reverse);
    }

    public static int fastReverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public static int reverse(int x) {
        // 先将符号订正
        if (x < 0) {
            x = -x;
            String result = reverseInt(x, "");
            try {
                Integer integer = Integer.valueOf(result);
                return -integer;
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            String result = reverseInt(x, "");
            try {
                return Integer.valueOf(result);
            } catch (NumberFormatException e) {
                return 0;
            }
        }

    }


    public static String reverseInt(int x, String result) {
        int i = x / 10;
        if (i != 0) {
            int j = x % 10;
            if (j == 0 && result.length() == 0) {
                return reverseInt(i, result);
            }
            result += j;
            return reverseInt(i, result);

        } else {
            int j = x % 10;
            result += j;
            return result;
        }

    }
}
