package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author yuanlin.yyl
 * @date 2020/03/08
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] status = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            status[i] = Integer.MAX_VALUE - 1;
        }

        for (int coin :coins) {
            for (int j = coin; j <= amount; j ++) {
                status[j] = Math.min(status[j - coin] + 1, status[j]);
            }
        }

        return status[amount] == Integer.MAX_VALUE - 1 ? -1 : status[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};

        String ss = "妈妈的吻—19朵红康乃馨鲜花+尤加利 38妇女节送女神女王长辈阿姨婆婆领导大姐生日礼物 同城上门祝福";
        System.out.println(ss.length());

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("012");

        List<String> newList = new ArrayList<>(list);

        newList.remove("123");

        System.out.println(newList.size());
        System.out.println(list.size());



        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, 11));
    }

}
