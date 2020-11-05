package cn.bigears.base.proxy;

/**
 * CalculatorImpl
 * @author shenyang
 * @date 2020/11/2
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        System.out.println("do add");
        return a + b;
    }
}
