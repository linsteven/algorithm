package Greedy;

import java.util.Arrays;

/**
 * 945. 使数组唯一的最小增量
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * @author yuanlin.yyl
 * @date 2020/03/22
 */
public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);

        int moveCount = 0;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] <= A[i - 1]) {
                moveCount += A[i - 1] - A[i] + 1;
                A[i] = A[i - 1] + 1;
            }
        }
        return moveCount;
    }

}
