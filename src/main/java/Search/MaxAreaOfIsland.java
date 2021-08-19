package Search;

import java.util.Stack;

/**
 * 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @author yuanlin.yyl
 * @date 2020/03/15
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        int[][] mark = new int[row][col];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == 1 && mark[i][j] == 0) {
                    Stack<Integer> stack = new Stack<>();
                    mark[i][j] = 1;
                    stack.push(i * col + j);
                    int curArea = 1;
                    while (!stack.empty()) {
                        int index = stack.pop();
                        int ci = index / col;
                        int cj = index % col;
                        for (int dirIndex = 0; dirIndex < 4; dirIndex ++) {
                            int x = ci + dir[dirIndex][0];
                            int y = cj + dir[dirIndex][1];
                            if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1 && mark[x][y] == 0) {
                                mark[x][y] = 1;
                                stack.push(x * col + y);
                                curArea ++;
                            }
                        }
                    }
                    maxArea = curArea > maxArea ? curArea : maxArea;
                }
            }
        }

        return maxArea;
    }


}
