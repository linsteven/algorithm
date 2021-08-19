package Array;

import java.util.Arrays;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author yuanlin.yyl
 * @date 2021/08/19
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int pre = nums[0] - 1;
        int preIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == pre) {
                i ++;
            }
            if ( i == nums.length) {
                break;
            }
            nums[preIndex ++] = nums[i];
            pre = nums[i];
        }

        return preIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
