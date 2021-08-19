package Array;

/**
 * 283. 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author yuanlin.yyl
 * @date 2021/08/19
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 != nums[i]) {
                nums[index ++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
