package bigears.base.unicode;

import java.io.UnsupportedEncodingException;

/**
 * UnicodeTest
 *
 * @author shenyang
 */
public class UnicodeTest {

    public static void main(String[] args) {

        String music = "\uD834\uDD1E";
        // 2
        System.out.println(music.length());
        // 1d11e
        System.out.println(Integer.toHexString(music.codePointAt(0)));
        // d834
        System.out.println(Integer.toHexString(music.codePointBefore(1)));
        // dd1e
        System.out.println(Integer.toHexString(music.codePointAt(1)));
        try {
            System.out.println(music.getBytes("utf-16").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
