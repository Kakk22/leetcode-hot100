package com.cyf.hot;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author 陈一锋
 * @date 2021/10/7 11:42 上午
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abcacebda"));
//        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
        System.out.println((double) 29/2);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>(64);
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            //每次都更新当前值的最大索引
            map.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
