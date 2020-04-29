package cn.bigears.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * Solution268
 * @author shenyang
 * @date 2020/4/29
 */
public class Solution268 {

    /**
     * 将数组排序,然后找到不连续的地方(可以直接使用Arrays.sort(nums)来排序)
     * 空间使用低,速度慢
     */
    private static int missingNumberOne(int[] nums) {
        if (nums.length == 1) {
            return Math.abs(nums[0] - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
        }
        return nums[0] > 0 ? 0 : nums[nums.length - 1] + 1;
    }

    /**
     * 从0开始遍历,找到缺的值
     * 空间使用低,速度慢
     */
    private static int missingNumberTwo(int[] nums) {
        HashSet<Integer> hashSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int i = 0;
        while (true) {
            if (!hashSet.contains(i)) {
                return i;
            }
            if (i == nums.length) {
                break;
            }
            i++;
        }
        return nums.length;
    }

    /**
     * 从0开始到nums的length求和,然后减去数组的所有值的和,就是少的值
     */
    public static int missingNumberThree(int[] nums) {
        int result = 0;
        for (int i = 1; i <= nums.length; i++) {
            result += i - nums[i - 1];
        }
        return result;
    }

    /**
     * 使用^计算符,比如4^4=0
     * 数组长度^nums的所有值^所有数组下标
     */
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 2};
        int[] nums2 = {0, 1, 3};
        int[] nums3 = {3, 1, 2};
        int[] nums4 = {3, 2, 1};
        int[] nums5 = {0};
        int[] nums6 = {1};
        System.out.println(missingNumberOne(nums1));
        System.out.println(missingNumberOne(nums2));
        System.out.println(missingNumberOne(nums3));
        System.out.println(missingNumberOne(nums4));
        System.out.println(missingNumberOne(nums5));
        System.out.println(missingNumberOne(nums6));
        System.out.println("----------------------");
        System.out.println(missingNumberTwo(nums1));
        System.out.println(missingNumberTwo(nums2));
        System.out.println(missingNumberTwo(nums3));
        System.out.println(missingNumberTwo(nums4));
        System.out.println(missingNumberTwo(nums5));
        System.out.println(missingNumberTwo(nums6));
    }

}
