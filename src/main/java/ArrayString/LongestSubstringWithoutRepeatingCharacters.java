package ArrayString;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author yuanlin.yyl
 * @date 2020/04/06
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] a  = new int[128];
        for (int i = 0; i < 128; i ++) {
            a[i] = -1;
        }
        int maxLen = 0;
        int startPos = 0;
        int curLen = 0;
        for (int i = 0; i < len; i ++) {
            int chVal = s.charAt(i);
            if (a[chVal] == -1 || a[chVal] < startPos) {
                a[chVal] = i;
                curLen ++;
                maxLen = curLen > maxLen ? curLen : maxLen;
            } else {
                startPos = a[chVal] + 1;
                curLen = i - startPos + 1;
                a[chVal] = i;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        String s = " ";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

}
