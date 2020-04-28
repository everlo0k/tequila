package cn.bigears.leetcode;

/**
 * Solution264
 * @author shenyang
 * @date 2020/4/28
 */
public class Solution264 {

    private static int nthUglyNumberOne(int n) {
        int num = 0;
        for (int i = 1; ; i++) {
            if (isUnlyOne(i)) {
                num++;
            }
            if (num == n) {
                return i;
            }
        }
    }

    private static boolean isUnlyOne(int n) {
        while (true) {
            if (n % 5 == 0) {
                n = n / 5;
                if (n == 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        while (true) {
            if (n % 3 == 0) {
                n = n / 3;
                if (n == 1) {
                    return true;
                }
            } else {
                break;
            }
        }
        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                break;
            }
        }
        return n == 1;
    }

    /**
     * 核心的逻辑是任何一个ugly数都是现有ugly数据2或者3或者5的倍数
     * 剩下的事情,就是用2,3,5分别去乘现有ugly数组中的每一个值,将最小结果逐步存入数组
     * i2, i3, i5分别表示2,3,5已经遍历过的ugly数组位置
     */
    private static int nthUglyNumberTwo(int n) {
        int[] ugly = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        int min;
        for (int i = 1; i < n; i++) {
            min = Math.min(2 * ugly[i2], Math.min(3 * ugly[i3], 5 * ugly[i5]));
            ugly[i] = min;
            if (min == 2 * ugly[i2]) {
                i2++;
            }
            if (min == 3 * ugly[i3]) {
                i3++;
            }
            if (min == 5 * ugly[i5]) {
                i5++;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(nthUglyNumberOne(1111));
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        System.out.println(nthUglyNumberTwo(1111));
        System.out.println(System.currentTimeMillis() - time);
    }

}
