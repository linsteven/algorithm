package Math;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuanlin.yyl
 * @date 2020/02/17
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                sb.append(romans[i]);
                num -= nums[i];
            }
        }

        return sb.toString();
    }

    public String intToRoman2(int num) {

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();
        for (Integer key : map.keySet()) {
            if (num >= key) {
                String val = map.get(key);
                int count = num / key;
                while(count-- > 0) {
                    sb.append(val);
                }
                num = num % key;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        integerToRoman.intToRoman(1000);
    }

}
