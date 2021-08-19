package BinarySearch;

/**
 * 35. 搜索插入位置
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author yuanlin.yyl
 * @date 2020/04/05
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findTarget(nums, 0 ,nums.length - 1, target);
    }

    public int findTarget(int[] nums, int i, int j, int target) {
        if (i > j) {
            return i;
        }
        int mid = (i + j) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return findTarget(nums, i, mid - 1, target);
        } else {
            return findTarget(nums, mid + 1, j, target);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, 0));
    }

}
