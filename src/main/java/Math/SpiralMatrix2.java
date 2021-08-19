package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanlin.yyl
 * @date 2020/02/19
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] arrRet = new int[n][n];
        int start = 1;
        int x1 = 0, x2 = n -1, y1 = 0, y2 = n -1;
        while (x1 <= x2 && y1 <= y2) {
            for (int i = y1; i <= y2; i ++) {
                arrRet[x1][i] = start ++;
            }
            for (int i = x1 + 1; i <= x2; i++) {
                arrRet[i][y2] = start ++;
            }
            if (x1 < x2 && y1 < y2) {
                for (int c = y2 - 1; c >= y1; c --) {
                    arrRet[x2][c] = start ++;
                }
                for (int r = x2 - 1; r > x1; r --) {
                    arrRet[r][y1] = start ++;
                }
            }
            x1 ++;
            y1 ++;
            x2 --;
            y2 --;
        }
        return arrRet;
    }

    public static void main(String[] args) {
        //Map<Object, Integer> matchFieldChannelItemMap = new HashMap<>();
        String ss = " ";
        ss = ss.trim();
        System.out.println(ss.length());
    }

}
