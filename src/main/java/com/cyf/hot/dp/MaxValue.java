package com.cyf.hot.dp;

/**
 * @author 陈一锋
 * @date 2023/2/15 10:15 下午
 */
public class MaxValue {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(new MaxValue().maxValue(nums));
    }

    public int maxValue(int[][] grid) {

        // dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
