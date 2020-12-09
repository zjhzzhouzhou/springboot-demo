package com.gupao.springbootdemo.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zhouzhou
 * @Date: 2020/11/23$ 17:36$
 */
public class LongestCommonPrefixTest {

    public static void main(String[] args) {
        String[] strArr = new String[]{"adff","adf"};
        String s = longestCommonPrefix(strArr);
        System.out.println(s);
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1){
            return "";
        }
        List<char[]> strChars = new ArrayList<>();
        for (String str : strs) {
            strChars.add(str.toCharArray());
        }
        // 首先先取第一个字符串第一个字符
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strChars.size(); j++) {
                char[] chars1 = strChars.get(j);
                if (chars1.length >= i+1 &&chars[i] == chars1[i]){
                    continue;
                }else {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length < 1){
            return "";
        }
        List<char[]> strChars = new ArrayList<>();
        for (String str : strs) {
            strChars.add(str.toCharArray());
        }
        // 首先先取第一个字符串第一个字符
        char[] chars = strs[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strChars.size(); j++) {
                char[] chars1 = strChars.get(j);
                if (chars1.length >= i+1 &&chars[i] == chars1[i]){
                    continue;
                }else {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }
}
