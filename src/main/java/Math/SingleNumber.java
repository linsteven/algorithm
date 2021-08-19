package Math;

/**
 * @author yuanlin.yyl
 * @date 2020/02/16
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int val : nums) {
            ret = ret ^ val;
        }
        return ret;
    }

}
