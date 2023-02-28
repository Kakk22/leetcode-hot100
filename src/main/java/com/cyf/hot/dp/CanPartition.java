package com.cyf.hot.dp;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * @author 陈一锋
 * @date 2023/2/28 9:54 下午
 */
public class CanPartition {

    public static void main(String[] args) {
        new CanPartition().canPartition(new int[]{1,5,11,5});
//        new CanPartition().canPartition(new int[]{1,2,3,5});
//        new CanPartition().canPartition(new int[]{2,2,1,1});
    }

    public boolean canPartition(int[] nums) {
        //与494. 目标和 类似，属于01背包问题，可以把问题抽象为“给定一个数组和一个容量为x的背包，求有多少种方式让背包装满（有多少种子///集能让子集之和等于背包容量）?"
//递推公式：dp[i] = dp[i] + dp[i-num] ，对于当前的第i个物品，有拿和不拿两种情况，dp[i]表示不拿的情况，dp[i-num]表示拿的情况，因此要将两者相加。
        // dp[i] = dp[i] + dp[i-num];

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;//和不为偶数
        }

        int W = sum / 2; //相当于背包总数量
        int[] dp = new int[W + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W] != 0;
    }
}
