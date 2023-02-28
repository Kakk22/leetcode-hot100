package com.cyf.hot.dp;

import java.util.Arrays;

/**
 * @author 陈一锋
 * @date 2022/12/18 11:48 上午
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange bean = new CoinChange();
        System.out.println(bean.coinChange(new int[]{2}, 3));
    }


    public int coinChange(int[] coins, int amount) {
        //价格状态dp  dp[11] 表示凑够11元最少需要多少个硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 外层遍历所有状态 得到dp[1] dp[2] .... 的值
        for (int i = 1; i <= amount; i++) {
            // 循环面额 得到凑出dp[i] 需要的最小硬币数量
            for (int coin : coins) {
                int currentCoin = i - coin;
                //子问题无解
                if (currentCoin < 0 || dp[currentCoin] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[currentCoin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
