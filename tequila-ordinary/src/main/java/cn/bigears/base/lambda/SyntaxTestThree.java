package cn.bigears.base.lambda;

/**
 * SyntaxTestThree lambda表达式中引用构造方法
 * @author shenyang
 * @date 2019/12/31
 */
public class SyntaxTestThree {

    public static void main(String[] args) {
        BigearsMaker bigearsMaker = () -> new Bigears();
        System.out.println(bigearsMaker.make());

        BigearsMakerPlus bigearsMakerPlus = (name, age) -> new Bigears(name, age);
        System.out.println(bigearsMakerPlus.make("bigears",18));

        bigearsMaker = Bigears::new;
        System.out.println(bigearsMaker.make());

        bigearsMakerPlus = Bigears::new;
        System.out.println(bigearsMakerPlus.make("bigears",18));
    }


    static class Bigears {

        private String name;

        private int age;

        Bigears(String name, int age) {
            this.name = name;
            this.age = age;
            System.out.println("有参");
        }

        Bigears() {
            System.out.println("无参");
        }
    }

    @FunctionalInterface
    interface BigearsMaker {
        /**
         * make bigears
         * @return bigears
         */
        Bigears make();
    }

    @FunctionalInterface
    interface BigearsMakerPlus {
        /**
         * make bigears
         * @param name 名字
         * @param age  年龄
         * @return bigears
         */
        Bigears make(String name, int age);
    }

}
