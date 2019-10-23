package bigears.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 　The function twoSum should return indices of the two numbers such that they add up to the target,
   where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 　You may assume that each input would have exactly one solution.
 　Input: numbers={2, 7, 11, 15}, target=9
 　Output: index1=1, index2=2
 *
 * @author shenyang
 */
public class Solution001 {

    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("twoSum1 num1:" + nums[i]);
                    System.out.println("twoSum1 num2:" + nums[j]);
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println("twoSum2 num1:" + (target - nums[i]));
                System.out.println("twoSum2 num2:" + nums[i]);
                return new int[] { map.get(target - nums[i]), i };
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] t = { 2, 7, 11, 15 };
        int target = 26;
        Solution001.twoSum1(t, target);
        Solution001.twoSum2(t, target);
    }

}
