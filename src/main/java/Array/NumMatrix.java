package Array;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @author yuanlin.yyl
 * @date 2021/08/20
 */
public class NumMatrix {

    private int[][] preSumMatrix;

    /**
     * 时间复杂度 O(n*m)
     * 空间复杂度 O(n*m)
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        preSumMatrix = new int[row+1][col+1];

        for (int i = 0; i <= row; i ++) {
            preSumMatrix[i][0] = 0;
        }

        for (int j = 1; j <= col; j ++) {
            preSumMatrix[0][j] = 0;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j ++) {
                preSumMatrix[i][j] = matrix[i-1][j-1] + preSumMatrix[i-1][j] + preSumMatrix[i][j-1] - preSumMatrix[i-1][j-1];
            }
        }
    }

    /**
     * 时间复杂度 O(1)
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSumMatrix[row2+1][col2+1] - preSumMatrix[row2+1][col1] - preSumMatrix[row1][col2+1] + preSumMatrix[row1][col1];
    }

}
