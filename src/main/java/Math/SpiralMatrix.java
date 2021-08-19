package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanlin.yyl
 * @date 2020/02/16
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> retList = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return retList;
        }
        int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;
        //System.out.println("rowMax: " + rowMax + " colMax: " + colMax);
        //int[][] dirArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //int x = 0, y = 0;
        //int dirIndex = 0;

        while (true) {
            for (int j = colMin; j <= colMax; j ++) {
                retList.add(matrix[rowMin][j]);
            }
            rowMin ++;
            if (rowMin > rowMax) break;
            for (int i = rowMin; i <= rowMax; i ++) {
                retList.add(matrix[i][colMax]);
            }
            colMax --;
            if (colMin > colMax) break;
            for (int j = colMax; j >= colMin; j --) {
                retList.add(matrix[rowMax][j]);
            }
            rowMax --;
            if (rowMin > rowMax) break;
            for (int i = rowMax; i >= rowMin; i--) {
                retList.add(matrix[i][colMin]);
            }
            colMin ++;
            if (colMin > colMax) break;
        }
        return retList;

        //retList.add(matrix[0][0]);
        //while (true) {
        //    if (x == rowMin && y == colMax) {
        //        rowMin ++;
        //        dirIndex = (dirIndex + 1) % 4;
        //        System.out.println("rowMin ++");
        //    }
        //    if (x == rowMax && y == colMax) {
        //        colMax --;
        //        dirIndex = (dirIndex + 1) % 4;
        //        System.out.println("colMax --");
        //    }
        //    if (x == rowMax && y == colMin) {
        //        rowMax --;
        //        dirIndex = (dirIndex + 1) % 4;
        //        System.out.println("rowMax --");
        //    }
        //    if ((x != 0 && y != 0) && x == rowMin && y == colMin) {
        //        colMin ++;
        //        dirIndex = (dirIndex + 1) % 4;
        //        System.out.println("colMin ++");
        //    }
        //    if (rowMin > rowMax || colMin > colMax) {
        //        break;
        //    }
        //
        //    x += dirArr[dirIndex][0];
        //    y += dirArr[dirIndex][1];
        //
        //    retList.add(matrix[x][y]);
        //    System.out.println("dirIndex: " + dirIndex + " x: " + x + " y: " + y);
        //}

        //return retList;
    }

    public static void main(String[] args) {
        //int[][] input = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int[][] input = new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};
        int[][] input = new int[][]{{1}, {3}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> retList = spiralMatrix.spiralOrder(input);
        System.out.println(retList.toString());

    }

}
