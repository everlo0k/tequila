package cn.bigears.base.lang;

/**
 * StackTraceElementTest
 * @author shenyang
 * @date 2023-12-26
 */
public class StackTraceElementTest {

    public static void main(String[] args) {
        Bigears.smallFlowersSay();
    }

    public static class Bigears {
        static void smallFlowersSay() {
            SmallFlowers smallFlowers = new SmallFlowers();
            smallFlowers.say();
        }
    }
}


