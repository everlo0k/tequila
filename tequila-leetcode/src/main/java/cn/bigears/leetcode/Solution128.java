package cn.bigears.leetcode;

/**
 * Solution128
 * @author shenyang
 * @date 2020/5/6
 */
public class Solution128 {

    private static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int result = 1;
        int flag = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                flag++;
            } else {
                if (flag > result) {
                    result = flag;
                }
                flag = 1;
            }
        }
        return result > flag ? result : flag;
    }

    public static void main(String[] args) {
        int[] aa = {5, 1, 3, 4};
        System.out.println(longestConsecutive(aa));
    }
}
