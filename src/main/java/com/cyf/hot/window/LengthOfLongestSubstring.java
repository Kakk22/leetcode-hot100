package com.cyf.hot.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * s = "abcabcbb"  -> 3
 * s = "bbbbbb"    -> 1
 * s = "pwwkew"    -> 3  kwe
 *
 * @author 陈一锋
 * @date 2022/11/14 8:54 下午
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring bean = new LengthOfLongestSubstring();
//        System.out.println(bean.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(bean.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(bean.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(bean.lengthOfLongestSubstring(" "));
        System.out.println(bean.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //滑动窗口
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 这里为什么要用max函数呢
                // 1. left只有再i遇到重复字符时才变动
                // 2. 变动的位置 则是上一次重复字符的前一位  因为如果直接取map.get(c) + 1 有可能中间已经有重复字符了 如: abba 走到a时 left应该取b的位置
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            //更新最大值 +1 是因为 i - 0 =0  i从0开始 所以要加一
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
