package DP;

/**
 * 152. 乘积最大子序列
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author yuanlin.yyl
 * @date 2020/03/16
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        int maxVal = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            int x = i % 2, y = (i - 1) % 2;
            if (nums[i] >= 0) {
                dp[x][0] = Math.max(dp[y][0] * nums[i], nums[i]);
                dp[x][1] = Math.min(dp[y][1] * nums[i], nums[i]);
            } else {
                dp[x][0] = Math.max(dp[y][1] * nums[i], nums[i]);
                dp[x][1] = Math.min(dp[y][0] * nums[i], nums[i]);
            }
            maxVal = dp[x][0] > maxVal ? dp[x][0] : maxVal;
        }
        return maxVal;

    }

    public int maxProductBad(int[] nums) {
        int[] data = new int[nums.length];
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i; j < nums.length; j ++) {
                if (i == j) {
                    data[j] = nums[j];
                } else {
                    data[j] = data[j - 1] * nums[j];
                }
                maxVal = data[j] > maxVal ? data[j] : maxVal;
            }
        }
        return maxVal;
    }

}
