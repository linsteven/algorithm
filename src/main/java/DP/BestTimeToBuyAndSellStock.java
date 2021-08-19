package DP;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 这是贪心，not DP
 *
 * @author yuanlin.yyl
 * @date 2020/03/16
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int maxVal = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > minPrice) {
                maxVal = (prices[i] - minPrice > maxVal) ?  prices[i] - minPrice : maxVal;
            } else {
                minPrice = prices[i];
            }
        }

        return maxVal;
    }

}
