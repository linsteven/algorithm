package DP;


/**
 * 72. 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 * @author yuanlin.yyl
 * @date 2020/04/12
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j ++) {
            if (word1.charAt(0) == word2.charAt(j)) {
                dp[0][j] = j;
            } else if (j != 0) {
                dp[0][j] = dp[0][j-1] + 1;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            if (word2.charAt(0) == word1.charAt(i)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = min(dp[i-1][j-1], dp[i][j-1] + 1, dp[i-1][j] + 1);
                } else {
                    dp[i][j] = min(dp[i-1][j-1] + 1, dp[i][j-1] + 1, dp[i-1][j] + 1);
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int min(int a, int b, int c) {
        int minVal = Integer.MAX_VALUE;
        if (a < minVal) {
            minVal = a;
        }
        if (b < minVal) {
            minVal = b;
        }
        if (c < minVal) {
            minVal = c;
        }
        return minVal;
    }

}
