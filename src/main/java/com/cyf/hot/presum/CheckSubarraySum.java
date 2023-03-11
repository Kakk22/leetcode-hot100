package com.cyf.hot.presum;

import java.util.HashSet;
import java.util.Set;

/**
 * 523. 连续的子数组和
 * 
 * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *
 *
 * @author 陈一锋
 * @date 2023/3/11 5:23 下午
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        System.out.println(checkSubarraySum.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            // sum 是前 i+1 项和，每次加入集合的是前 i 项和的模。 当两个前缀和*关于模 k 同余*时，它们的差值就是满足条件的子数组和、
            // 29 % 6 = 5  23 % 6 = 5   29和23的差值 就是中间的子数组和 2 和 4 的和
            if (set.contains(sum % k)) {
                return true;
            }
            // 前 i项和的余数
            set.add((sum - num) % k);
        }
        return false;
    }
}
