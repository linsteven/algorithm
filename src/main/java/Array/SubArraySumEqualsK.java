package Array;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * @author yuanlin.yyl
 * @date 2021/08/20
 */
public class SubArraySumEqualsK {

    /**
     * 时间复杂度 O(n*n)，不够好
     * 空间复杂度 O(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] preSums = new int[len];
        preSums[0] = nums[0];
        for (int i = 1; i < len; i ++) {
            preSums[i] = preSums[i - 1] + nums[i];
        }

        int subCount = 0;
        for (int i = 0; i < len; i ++) {
            if (preSums[i] == k) {
                subCount ++;
            }
            for (int j = i + 1; j < len; j ++) {
                if (preSums[j] - preSums[i] == k) {
                    subCount ++;
                }
            }
        }
        return subCount;
    }

}
