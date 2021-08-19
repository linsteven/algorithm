package DP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * @author yuanlin.yyl
 * @date 2020/03/16
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int row = triangle.size();
        int[] pathLen = new int[row];
        for (List<Integer> line : triangle) {
            for (int i = line.size() - 1; i >= 0; i --) {
                if (i == 0) {
                    pathLen[i] = pathLen[i] + line.get(i);
                } else if (i == line.size() - 1) {
                    pathLen[i] = pathLen[i - 1] + line.get(i);
                } else {
                    pathLen[i] = Math.min(pathLen[i - 1], pathLen[i]) + line.get(i);
                }
            }
        }

        int minVal = pathLen[0];
        for (int val : pathLen) {
            minVal = val < minVal ? val : minVal;
        }
        return minVal;
    }

    public void fun(Map<Integer, Integer> testMap) {
        testMap.put(2,2);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Map<Integer, Integer> testMap = new HashMap<>();
        testMap.put(1,1);
        System.out.println(testMap.size());
        triangle.fun(testMap);
        System.out.println(testMap.size());

    }
}
