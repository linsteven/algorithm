package DP;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author yuanlin.yyl
 * @date 2020/03/30
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            // should not be happened
            return Integer.MIN_VALUE;
        }

        int curSum = nums[0];
        int maxSum = curSum;
        for (int i = 1; i < nums.length; i ++) {
            curSum = Math.max(nums[i], nums[i] + curSum);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        maximumSubarray.maxSubArray(nums);
    }

}
