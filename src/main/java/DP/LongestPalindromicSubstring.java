package DP;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author yuanlin.yyl
 * @date 2020/03/29
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        int maxLen = 1;
        int maxLeft = 0;
        int maxRight = 0;
        for (int j = 0; j < len; j ++) {
            dp[j][j] = 1;
        }
        for (int i = 2; i <= len; i ++) {
            for (int j = 0; j <= len - i; j ++) {
                if (i == 2) {
                    dp[j][j + 1] = (s.charAt(j) == s.charAt(j + 1)) ? 2 : 1;
                } else {
                    if (dp[j + 1][j + i - 2] == i - 2 && s.charAt(j) == s.charAt(j + i - 1)) {
                        dp[j][j + i - 1] = dp[j + 1][j + i - 2] + 2;
                    } else {
                        dp[j][j + i - 1] = Math.max(dp[j][j + i - 2], dp[j + 1][j + i - 1]);
                    }
                }

                if (dp[j][j + i - 1] == i && maxLen < i) {
                    maxLen = i;
                    maxLeft = j;
                    maxRight = j + i - 1;
                }
            }
        }

        return s.substring(maxLeft, maxRight + 1);
    }

}
