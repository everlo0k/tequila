package cn.bigears.lambda.sample1;

/**
 * OrderFactoryCustomizer
 * @author shenyang
 * @date 2024-01-15
 */
@FunctionalInterface
public interface OrderFactoryCustomizer<T extends OrderFactory> {

    void customize(T factory);

}
