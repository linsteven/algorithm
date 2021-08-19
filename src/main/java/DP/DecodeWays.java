package DP;

/**
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * @author yuanlin.yyl
 * @date 2020/03/30
 */
public class DecodeWays {

    //'A' -> 1
    //'B' -> 2
    //...
    //'Z' -> 26
    public int numDecodings(String s) {
        if (null == s || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int preCount = 1;
        int wayCount = 1;
        int slen = s.length();
        for (int i = 1; i < slen; i++) {
            if (i < slen - 1 && s.charAt(i + 1) == '0') {
                preCount = wayCount;
                continue;
            }

            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0') {
                    return 0;
                }
                preCount = wayCount;
                continue;
            }

            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                int total = preCount + wayCount;
                preCount = wayCount;
                wayCount = total;
                continue;
            }

            preCount = wayCount;
        }

        return wayCount;
    }

    public static void main(String[] args) {
        //DecodeWays decodeWays = new DecodeWays();
        //System.out.println(decodeWays.numDecodings("226"));

        String txt = "哈哈哈sd";
        System.out.println(txt.length());

    }

}
