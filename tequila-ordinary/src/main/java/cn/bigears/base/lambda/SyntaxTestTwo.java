package cn.bigears.base.lambda;

import java.util.function.Function;

/**
 * SyntaxTestTwo
 * @author shenyang
 * @date 2019/12/30
 */
public class SyntaxTestTwo {

    public static void main(String[] args) {
        // 如果SingleParamSingleReturn需要在多处实现,这样写多次,不易于维护
        SingleParamSingleReturn singleParamSingleReturnOne = a -> a * 2;
        SingleParamSingleReturn singleParamSingleReturnTwo = a -> a * 2;
        // 使用一般方法的调用方式
        SingleParamSingleReturn singleParamSingleReturnThree = b -> test(b);
        // 使用方法引用,及replace with method reference
        SingleParamSingleReturn singleParamSingleReturnFour = SyntaxTestTwo::test;
        // 非静态方法需要对象才能被调用
        SyntaxTestTwo syntaxTestTwo = new SyntaxTestTwo();
        // 引用的方法的返回值一定要和接口中的方法返回值一致
        MultipleParamSingleReturn multipleParamSingleReturn = syntaxTestTwo::test;
        // 类似的下面两个Function是等价的
        Function<Integer, Integer> function = a -> SyntaxTestTwo.test(a);
        Function<Integer, Integer> function2 = SyntaxTestTwo::test;
        System.out.println(function2.apply(1));
    }

    @FunctionalInterface
    interface SingleParamSingleReturn {
        /**
         * test
         * @param a 参数
         * @return 计算结果
         */
        int test(int a);
    }

    @FunctionalInterface
    interface MultipleParamSingleReturn {
        /**
         * test
         * @param a 参数
         * @param b 参数
         * @return 计算结果
         */
        int test(int a, int b);
    }

    private static int test(int a) {
        return a * 2;
    }

    private int test(int a, int b) {
        return a + b;
    }

}
