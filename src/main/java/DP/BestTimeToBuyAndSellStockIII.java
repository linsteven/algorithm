package DP;

/**
 * @author yuanlin.yyl
 * @date 2020/03/22
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int[][][] dp = new int[n][3][2]; // todo
        //dp[0][1][1] = - prices[0]; // todo
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;


        for (int i = 0; i < prices.length; i ++) {
            System.out.println("\ni : " + i + "\n-----");
            int cur = i % 2;
            int pre = (i + 1) % 2;
            for (int k = 1; k <= 2; k ++) {
                dp[cur][k][0] = Math.max(dp[pre][k][0], dp[pre][k - 1][1] + prices[i]);
                dp[cur][k][1] = Math.max(dp[pre][k][0] - prices[i], dp[pre][k][1]);
                System.out.println(dp[cur][k][0] + "  " + dp[cur][k][1]);
            }
        }

        int maxVal = 0;
        for (int k = 0; k <= 2; k ++) {
            maxVal = Math.max(dp[(prices.length - 1) % 2][k][0], maxVal);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,4,5};
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        System.out.println(obj.maxProfit(prices));
    }

}
