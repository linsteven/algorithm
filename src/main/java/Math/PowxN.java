package Math;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * @author yuanlin.yyl
 * @date 2020/05/11
 */
public class PowxN {

    /**
     * 递归写法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            long nn = n;
            return 1 / myPowFunc(x, nn * -1);
        } else {
            return myPowFunc(x, n);
        }
    }

    private double myPowFunc(double x, long n) {
        System.out.println(n);
        if (0 == n) {
            return 1;
        } else if (n % 2 == 1) {
            return myPowFunc(x, n - 1) * x;
        } else {
            double temp = myPowFunc(x, n / 2);
            return temp * temp;
        }
    }


    public static void main(String[] args) {
        PowxN powxN = new PowxN();
        System.out.println(powxN.myPow(2.0, -2147483648));
    }

}
