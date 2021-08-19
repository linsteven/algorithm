package Array;

/**
 * 27. 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 * @author yuanlin.yyl
 * @date 2021/08/19
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index ++] = nums[i];
            }
        }

        return index;
    }

}
