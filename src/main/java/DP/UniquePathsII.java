package DP;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @author yuanlin.yyl
 * @date 2020/03/29
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];
        boolean hasBlocked = false;
        for (int i = 0; i < n; i++) {
            if (!hasBlocked) {
                if (obstacleGrid[0][i] == 1) {
                    dp[i] = 0;
                    hasBlocked = true;
                } else {
                    dp[i] = 1;
                }

            } else {
                dp[i] = 0;
            }
        }

        for (int i = 1; i < m; i ++) {
            // j = 0
            dp[0] = (obstacleGrid[i][0] == 1) ? 0 : dp[0];
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }

        return dp[n - 1];
    }

}
