package com.cyf.hot.huisuo;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。

 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

 

 示例 1：

 输入：nums = [1,1,1,1,1], target = 3
 输出：5
 解释：一共有 5 种方法让最终目标和为 3 。
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3
 示例 2：

 输入：nums = [1], target = 1
 输出：1

 * @author 陈一锋
 * @date 2023/2/6 9:19 下午
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    int ans = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(0, target, nums, 0);
        return ans;
    }

    public void dfs(int sum, int target, int[] nums, int idx) {
        if (idx == nums.length) {
            if (sum == target) {
                ans++;
            }
            return;
        }


        dfs(sum + nums[idx], target, nums, idx + 1);
        dfs(sum - nums[idx], target, nums, idx + 1);

    }
}
