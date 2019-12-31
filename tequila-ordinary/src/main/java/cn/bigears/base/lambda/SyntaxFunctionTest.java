package cn.bigears.base.lambda;

import java.util.function.Function;

/**
 * SyntaxFunctionTest
 * @author shenyang
 * @date 2019/12/31
 */
public class SyntaxFunctionTest {
    public static void main(String[] args) {
        Multiplication multiplication = new Multiplication();
        // 泛型第一个参数表示实例方法入参,第二个参数表示实例方法返回
        Function<Integer, String> function = multiplication::multiply;
        System.out.println(function.apply(2));
    }
}

class Multiplication {
    String multiply(int a) {
        return String.valueOf(a * a);
    }
}
