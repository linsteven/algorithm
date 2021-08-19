package DP;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @author yuanlin.yyl
 * @date 2020/04/12
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        for (int j = 0; j < n; j ++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[j] = 1;
            } else if ( j != 0) {
                dp[j] = dp[j - 1];
            } else {
                dp[j] = 0;
            }
        }

        int[] pre = new int[2];
        for (int i = 1; i < m; i++) {
            pre[0] = dp[0];
            if (text1.charAt(i)  == text2.charAt(0)) {
                dp[0] = 1;
            }
            for (int j = 1; j < n; j++) {
                pre[j % 2] = dp[j];
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = pre[(j + 1) % 2] + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[n-1];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j ++) {
            if (text1.charAt(0) == text2.charAt(j)) {
                dp[0][j] = 1;
            } else if (j != 0) {
                dp[0][j] = dp[0][j-1];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            if (text2.charAt(0) == text1.charAt(i)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = max(dp[i-1][j-1] + 1, dp[i][j-1], dp[i-1][j]);
                } else {
                    dp[i][j] = max(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int max(int a, int b, int c) {
        int maxVal = Integer.MIN_VALUE;
        if (a > maxVal) {
            maxVal = a;
        }
        if (b > maxVal) {
            maxVal = b;
        }
        if (c > maxVal) {
            maxVal = c;
        }
        return maxVal;
    }

}
