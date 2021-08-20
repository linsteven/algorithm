package Array;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 * https://leetcode-cn.com/problems/corporate-flight-bookings/
 * @author yuanlin.yyl
 * @date 2021/08/21
 */
public class CorporateFlightBookings {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];

        for (int i = 0; i < bookings.length; i++) {
            diff[bookings[i][0]] += bookings[i][2];
            diff[bookings[i][1] + 1] -= bookings[i][2];
        }

        int[] total = new int[n + 1];
        total[0] = diff[1];
        for (int i = 2; i <= n + 1; i++) {
            total[i - 1] += diff[i] + total[i - 2];
        }

        return total;
    }

    public static void main(String[] args) {
        int[][] bookings = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        CorporateFlightBookings obj = new CorporateFlightBookings();
        int[] ret = obj.corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(ret));
    }

}
