package com.cyf.hot;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 陈一锋
 * @date 2021/10/7 11:42 上午
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
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
            map.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
