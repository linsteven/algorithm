package Array;

/**
 * 76. 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * @author yuanlin.yyl
 * @date 2020/05/24
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i ++) {
            map[t.charAt(i)] ++;
        }
        int counter = t.length();
        int start = 0, end = 0, slen = s.length();
        int minlen = s.length() + 1;
        int retStart = 0, retEnd = 0;

        while(end < slen) {
            if (map[s.charAt(end)] > 0) {
                counter --;
            }
            map[s.charAt(end)] --;
            end ++;

            while (counter == 0) {
                if (end - start < minlen) {
                    minlen = end - start;
                    retStart = start;
                    retEnd = end;
                }

                if (0 == map[s.charAt(start)]) {
                    counter ++;
                }
                map[s.charAt(start)] ++;
                start ++;
            }
        }

        if (minlen == s.length() + 1) {
            return "";
        }

        return s.substring(retStart, retEnd);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }
}
