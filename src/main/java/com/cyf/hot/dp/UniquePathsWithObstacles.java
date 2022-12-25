package com.cyf.hot.dp;


/**
 * 63. 不同路径 II
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * @author 陈一锋
 * @date 2022/12/25 8:54 下午
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{1, 0}}));
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dp[i][j] 从 0 0 到 i,j位置有多少条路径

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1 || (i > 0 && dp[0][i - 1] == 0)) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    if (dp[i - 1][j] == 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
