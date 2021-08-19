package Array;

/**
 * 面试题03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author yuanlin.yyl
 * @date 2020/03/22
 */
public class MultiNumber {

    public int findRepeatNumber(int[] nums) {
        if (null == nums || nums.length < 2) {
            return -1;
        }
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            if (nums[i] < 0 || nums[i] >= n) {
                return -1;
            }
            while (nums[i] != i) {
                int j = nums[i];
                if (nums[j] == j) {
                    return j;
                }
                nums[i] = nums[j];
                nums[j] = j;
            }
        }
        return -1;
    }

}
