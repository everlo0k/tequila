package cn.bigears.leetcode;

/**
 * Solution894
 * @author shenyang
 * @date 2020/5/8
 */
public class Solution849 {

    /**
     * 两边的距离是不需要除以2,用start和end单点记录
     * 如果有多个1,1之前的距离,如果是偶数除以2,奇数除以2加1
     */
    private static int maxDistToClosest(int[] seats) {
        int start = 0;
        int result = 0;
        int temp = 0;
        for (int seat : seats) {
            if (seat == 0) {
                start++;
            } else {
                break;
            }
        }
        int end = seats.length - start;
        for (int i = start; i < seats.length; i++) {
            if (seats[i] == 0) {
                temp++;
            } else {
                end = end - temp - 1;
                if (temp >= result) {
                    result = temp;
                }
                temp = 0;
            }
        }
        return Math.max(Math.max((result & 1) == 0 ? result / 2 : result / 2 + 1, end), start);
    }

    public static void main(String[] args) {
        int[] seats1 = {1,0,0,1,0,1,0,1};
        int[] seats2 = {1,0};
        int[] seats3 = {1,0,0,0,0,0,0,1};
        int[] seats4 = {0,0,0,1,0,1,0,1};
        int[] seats5 = {0,0,1,0,0,0};
        int[] seats6 = {1,0,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1};
        System.out.println(maxDistToClosest(seats1));
        System.out.println(maxDistToClosest(seats2));
        System.out.println(maxDistToClosest(seats3));
        System.out.println(maxDistToClosest(seats4));
        System.out.println(maxDistToClosest(seats5));
        System.out.println(maxDistToClosest(seats6));
    }

}
