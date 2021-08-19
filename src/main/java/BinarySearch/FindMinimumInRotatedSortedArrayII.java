package BinarySearch;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @author yuanlin.yyl
 * @date 2020/04/06
 */
public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] >= nums[right]) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                left ++;
                right --;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,2,2,0,1};
        FindMinimumInRotatedSortedArrayII obj = new FindMinimumInRotatedSortedArrayII();
        System.out.println(obj.findMin(nums));
    }

}
