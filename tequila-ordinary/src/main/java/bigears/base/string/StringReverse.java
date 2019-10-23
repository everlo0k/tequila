package bigears.base.string;

/**
 * StringReverse
 *
 * @author shenyang
 */
public class StringReverse {

    public static String reverse1(String s) {
        if (s == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        return stringBuffer.reverse().toString();
    }

    public static String reverse2(String s) {
        if (s == null) {
            return null;
        }
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("s:" + StringReverse.reverse1(" abcde f"));
        System.out.println("s:" + StringReverse.reverse2(" abcde f"));
    }

}
