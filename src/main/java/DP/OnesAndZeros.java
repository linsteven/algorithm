package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

/**
 * 474. 一和零
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * @author yuanlin.yyl
 * @date 2020/03/08
 */
public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] status = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] a = countZeroesOnes(str);
            for (int i = m; i >= a[0]; i--) {
                for (int j = n; j >= a[1]; j--) {
                    status[i][j] = Math.max(status[i][j], status[i - a[0]][j - a[1]] + 1);
                }
            }
        }

        return status[m][n];
    }

    private int[] countZeroesOnes(String str) {
        int[] a = new int[2];
        for (int i = 0; i < str.length(); i ++) {
            a[str.charAt(i) - '0'] ++;
        }
        return a;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        OnesAndZeros onesAndZeros = new OnesAndZeros();
        System.out.println(onesAndZeros.findMaxForm(strs, 5, 3));
    }

}
