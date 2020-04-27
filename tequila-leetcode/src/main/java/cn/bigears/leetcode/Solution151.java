package cn.bigears.leetcode;

import java.util.Arrays;

/**
 * Solution151
 * @author shenyang
 * @date 2020/4/27
 */
public class Solution151 {

    /**
     * 从最右边开始遍历截取,效率较差
     */
    private String reverseWordsOne(String s) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (s.trim().equals("")) {
                break;
            }
            int i = s.trim().indexOf(" ");
            if (i <= 0) {
                sb.insert(0, s.trim() + " ");
                break;
            }
            sb.insert(0, s.trim().substring(0, i + 1));
            s = s.trim().substring(i + 1);
        }
        return sb.toString().trim();
    }

    /**
     * 用split来拆分,效率一般
     * 这里spilt单个空格可以替换成split("\\s+")
     */
    private static String reverseWordsTwo(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.trim().split(" ");
        Arrays.stream(array).forEach(item -> {
            if (!item.trim().equals("")) {
                sb.insert(0, item.trim() + " ");
            }
        });
        return sb.toString().trim();
    }

    /**
     * 将s转换为char[],然后翻转,然后遍历每一个String,再做翻转
     */
    private static String reverseWordsThree(String s) {
        // 为了防止翻转后最后没有空格,导致最后一个词没有翻转的情况,手工个空格
        s = " " + s;
        char[] chars = reverse(s.toCharArray(), 0, s.length() - 1);
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] != ' ') {
                chars[end++] = chars[i];
            } else if (i > 0 && chars[i - 1] != ' ') {
                reverse(chars, start, end - 1);
                chars[end++] = ' ';
                start = end;
            }
        }
        // 如果最后含有空格,需要截取空格
        return new String(chars, 0, end > 0 && chars[end - 1] == ' ' ? end - 1 : end);
    }

    private static char[] reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        String test = "  ";
        System.out.println(reverseWordsTwo(test));
        System.out.println(reverseWordsThree(test));
    }
}
