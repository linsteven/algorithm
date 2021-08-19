package DP;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author yuanlin.yyl
 * @date 2020/03/22
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int[][] dp = new int[2][2];
        dp[0][0] = - prices[0]; // 第 0 天买入
        dp[0][1] = 0; // 第 0 天不买

        int maxVal = 0;
        for (int i = 1; i < prices.length; i ++) {
            int cur = i % 2;
            int pre = (i + 1) % 2;
            dp[cur][0] = Math.max(dp[pre][1] - prices[i], dp[pre][0]);
            dp[cur][1] = Math.max(dp[pre][0] + prices[i], dp[pre][1]);
            maxVal = dp[cur][1];
        }

        return maxVal;

    }

}
