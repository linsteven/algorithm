package DP;

/**
 * @author yuanlin.yyl
 * @date 2020/05/24
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j ++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2 ,5};

        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(amount, coins));
    }

}
