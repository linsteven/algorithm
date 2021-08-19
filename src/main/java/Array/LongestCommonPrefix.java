package Array;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author yuanlin.yyl
 * @date 2020/05/24
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i ++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        String t = "ABC";
        System.out.println(t.indexOf(""));

        Integer[] aa = new Integer[10];

        aa[1] = 2;
        aa[3] = 4;

        List<Integer> list = Lists.newArrayList(aa);

        double b = 3;
        System.out.println(b);

        //ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        //
        //List<String> list = new ArrayList<>();
        //list.add("hello1");
        //list.add("hello2");
        //list.add("hello3");

        //ForkJoinTask task = forkJoinPool.submit(() -> {
        //    list.parallelStream().forEach(d -> {
        //        System.out.println("cur " + d);
        //        Thread current = Thread.currentThread();
        //        System.out.println(current.getId());
        //    });
        //
        //    System.out.println("ok");
        //    Thread current = Thread.currentThread();
        //    System.out.println(current.getId());
        //});
        //
        //try {
        //    task.get();
        //} catch (Exception e) {
        //    System.out.println("task get exception");
        //}



    }

}
