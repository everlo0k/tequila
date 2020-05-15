package cn.bigears.leetcode;

/**
 * Solution75
 * @author shenyang
 * @date 2020/5/15
 */
public class Solution75 {

    public void sortColorsOne(int[] nums) {
        int red = 0, white = 0;
        for (int num : nums) {
            if (num == 0) {
                red++;
                continue;
            }
            if (num == 1) {
                white++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
                continue;
            }
            if (i < red + white) {
                nums[i] = 1;
                continue;
            }
            nums[i] = 2;
        }
    }

    public void sortColorsTwo(int[] nums, int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                nums[++n2] = 2;
                nums[++n1] = 1;
                nums[++n0] = 0;
            } else if (nums[i] == 1) {
                nums[++n2] = 2;
                nums[++n1] = 1;
            } else if (nums[i] == 2) {
                nums[++n2] = 2;
            }
        }
    }

}
