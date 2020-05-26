package cn.bigears.leetcode;

/**
 * Solution121
 * @author shenyang
 * @date 2020/5/26
 */
public class Solution121 {

    /**
     * prices[0]默认为波谷值
     * 遍历数组,如果值更小,替换波谷值
     * 如果值大于波谷,则计算最大峰差
     */
    private static int maxProfitOne(int[] prices) {
        int length = prices.length;
        if (length < 1) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (min >= prices[i]) {
                min = prices[i];
                continue;
            }
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    /**
     * Kadane's Algorithm.
     */
    public int maxProfitTwo(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }


    public static void main(String[] args) {
        int[] prices0 = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {1, 2, 3, 4};
        int[] prices2 = {1, 2};
        int[] prices3 = {2, 1, 4};
        System.out.println(maxProfitOne(prices0));
        System.out.println(maxProfitOne(prices1));
        System.out.println(maxProfitOne(prices2));
        System.out.println(maxProfitOne(prices3));
    }


}
