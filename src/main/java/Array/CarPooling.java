package Array;

/**
 * 1094. 拼车
 * https://leetcode-cn.com/problems/car-pooling/
 * @author yuanlin.yyl
 * @date 2021/08/21
 */
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int start = 1000;
        int end = 0;
        for (int i = 0; i < trips.length; i ++) {
            if (trips[i][1] < start) {
                start = trips[i][1];
            }
            if (trips[i][2] > end) {
                end = trips[i][2];
            }
        }
        int[] diff = new int[end - start + 1];

        for (int i = 0; i < trips.length; i ++) {
            diff[trips[i][1] - start] += trips[i][0];
            diff[trips[i][2] - start] -= trips[i][0];
        }

        int curVal = 0;
        for (int i = start; i <= end; i ++) {
            curVal += diff[i - start];
            if (curVal > capacity) {
                return false;
            }
        }

        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        int end = 0;
        for (int i = 0; i < trips.length; i ++) {
            if (trips[i][2] > end) {
                end = trips[i][2];
            }
        }
        int[] diff = new int[end + 1];

        for (int i = 0; i < trips.length; i ++) {
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0];
        }

        int curVal = 0;
        for (int i = 0; i <= end; i ++) {
            curVal += diff[i];
            if (curVal > capacity) {
                return false;
            }
        }

        return true;
    }

}
