package cn.bigears.guava;

import com.google.common.base.CharMatcher;

/**
 * CharMatcherTest
 * @author shenyang
 * @date 2022/8/24
 */
public class CharMatcherTest {

    private void testCharMatcher(){
        System.out.println(CharMatcher.inRange('0', '9').retainFrom("mahesh123"));
        System.out.println(CharMatcher.is('h').retainFrom("mahesh123"));
    }

    public static void main(String[] args) {
        CharMatcherTest charMatcherTest = new CharMatcherTest();
        charMatcherTest.testCharMatcher();
    }
}
