package cn.bigears.base.lambda;

import java.util.function.BiFunction;

/**
 * SyntaxBiFunctionTest
 * @author shenyang
 * @date 2019/12/31
 */
public class SyntaxBiFunctionTest {

    private static int getPowerResult(Power power, int i) {
        return power.power(i);
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        PowerOfThree powerOfThree = new PowerOfThree();
        // 常规的多态使用方法
        System.out.println(SyntaxBiFunctionTest.getPowerResult(powerOfTwo, 3));
        // 使用函数式接口BiFunction,实现多态调用,这样增加了多态在方法引用中的便利性
        BiFunction<Power, Integer, Integer> function = Power::power;
        System.out.println(function.apply(powerOfThree, 3));
    }

}

interface Power {
    /**
     * power计算
     * @param i 入参
     * @return 计算结果
     */
    int power(int i);
}

class PowerOfTwo implements Power {
    @Override
    public int power(int i) {
        return (int) Math.pow(2, i);

    }
}

class PowerOfThree implements Power {
    @Override
    public int power(int i) {
        return (int) Math.pow(3, i);

    }
}
