package Math;

/**
 * @author yuanlin.yyl
 * @date 2020/02/16
 */
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for (int val : nums) {
            twos |= ones & val;
            ones ^= val;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

}
