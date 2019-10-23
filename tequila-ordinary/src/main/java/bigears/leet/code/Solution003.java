package bigears.leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution003
 *
 * @author shenyang
 */
public class Solution003 {

    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        // 遍历每一个字符，判断是否有重复，然后取最长的
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 判断s从start到end中是否有重复字符
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0, anc = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                anc = Math.max(anc, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return anc;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Solution003.lengthOfLongestSubstring1("v2c1345cvadgdschfss"));
        System.out.println(Solution003.lengthOfLongestSubstring2("v2c1345cvadgdschfss"));
        System.out.println(Solution003.lengthOfLongestSubstring3("v2c1345cvadgdschfss"));
    }

}
