package bigears.leet.code;

/**
 * Solution005
 *
 * @author shenyang
 */
public class Solution005 {

    public static String longestPalindrome(String s) {
        String maxPalindrome = "";
        int maxLength = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String temp = s.substring(i, j + 1);
                if (isPalindrome(temp) && maxLength < temp.length()) {
                    maxPalindrome = temp;
                    maxLength = temp.length();
                }
            }
        }
        return maxPalindrome;
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        String reverse = stringBuffer.reverse().toString();
        return reverse.equals(s);
    }


    public static void main(String[] args) {
        String palindrome = "adfadfccdddfdsdf";
        System.out.println(Solution005.longestPalindrome(palindrome));
    }

}
