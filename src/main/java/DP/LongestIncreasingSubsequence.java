package DP;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/cc/
 * @author yuanlin.yyl
 * @date 2020/05/23
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int res = 1;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
            System.out.println("i: " + i + " " + dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        System.out.println(obj.lengthOfLIS(nums));
    }

}
