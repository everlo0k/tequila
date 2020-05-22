package cn.bigears.leetcode;

/**
 * Solution122
 * @author shenyang
 * @date 2020/5/22
 */
public class Solution122 {

    private static int maxProfitOne(int[] prices) {
        int length = prices.length;
        if (length < 1) {
            return 0;
        }
        int max = 0;
        int temp = prices[0];
        for (int i = 1; i < length; i++) {
            // 当temp大于等于当前遍历值,设置temp=遍历值
            if (temp >= prices[i]) {
                temp = prices[i];
                continue;
            }
            // 如果存在下一个遍历值,且当前遍历值小于下一个遍历值,继续遍历
            if (i + 1 < length && prices[i] <= prices[i + 1]) {
                continue;
            }
            // 获得并计算收益
            max = max + prices[i] - temp;
            if (i + 1 < length) {
                temp = prices[i + 1];
            }
        }
        return max;
    }

    /**
     * 最大收益经过证明=对应于连续的峰和谷的高度之差
     */
    public int maxProfitTwo(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
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

