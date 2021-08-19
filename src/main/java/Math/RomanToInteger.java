package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanlin.yyl
 * @date 2020/02/17
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int ret = 0;
        int preVal = getVal(s.charAt(0));
        for (int i = 1; i < s.length(); i ++) {
            int val = getVal(s.charAt(i));
            if (val > preVal) {
                ret -= preVal;
            } else {
                ret += preVal;
            }
            preVal = val;
        }
        ret += preVal;
        return ret;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = 0;
        int inputLen = s.length();
        for (int i = 0; i < inputLen; i ++) {
            char ch = s.charAt(i);
            if (ch == 'I' || ch == 'X' || ch == 'C') {
                if (i + 1 < inputLen && map.get(s.charAt(i + 1)) > map.get(ch)) {
                    ret += map.get(s.charAt(i + 1)) - map.get(ch);
                    i ++;
                    continue;
                }
            }
            ret += map.get(ch);
        }
        return ret;
    }

    private int getVal(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
