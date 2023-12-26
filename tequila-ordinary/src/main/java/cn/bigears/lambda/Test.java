package cn.bigears.lambda;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Test
 * @author shenyang
 * @date 2023/4/12
 */
public class Test {

    public static void main(String[] args) {
        Optional<Double> optional = Optional.empty();
        Supplier<Double> supplier = () -> new Random().nextDouble();
        System.out.println(supplier.get());
        System.out.println(optional.orElseGet(supplier));
        Double d1 = new Double("12.2");
        Double d2 = Optional.ofNullable(d1).orElseGet(supplier);
        System.out.println(d2);
    }
}
