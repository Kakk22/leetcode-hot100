package com.cyf.hot.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈一锋
 * @date 2023/1/22 8:56 下午
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        char[] chars = "s".toCharArray();
        return ret;
    }
}
