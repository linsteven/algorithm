package DP;

import java.util.Arrays;

/**
 * @author yuanlin.yyl
 * @date 2020/03/08
 */
public class MinimumPathSum {

    /**
     * 优化为 一维数组
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] status = new int[n];
        status[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            status[i] = status[i - 1] + grid[0][i];
        }

        for (int row = 1; row < m; row ++) {
            for (int col = 0; col < n; col ++) {
                if (col == 0) {
                    status[0] = grid[row][0] + status[0];
                } else {
                    // 状态转移
                    status[col] = Math.min(status[col - 1], status[col]) + grid[row][col];
                }
            }
        }

        return status[n - 1];
    }

    /**
     * 二维数组
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] status = new int[m][n];
        status[0][0] = grid[0][0];
        for (int col = 1; col < n; col ++) {
            status[0][col] = grid[0][col] + status[0][col - 1];
        }

        for (int row = 1; row < m; row ++) {
            status[row][0] = grid[row][0] + status[row - 1][0];
        }

        for (int row = 1; row < m; row ++) {
            for(int col = 1; col < n; col ++) {
                status[row][col] = Math.min(status[row - 1][col], status[row][col - 1]) + grid[row][col];
            }
        }

        return status[m - 1][n - 1];
    }

    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2}, {5,6}, {1,1}};

        MinimumPathSum minimumPathSum = new MinimumPathSum();

        System.out.println(minimumPathSum.minPathSum(grid));
    }

}
