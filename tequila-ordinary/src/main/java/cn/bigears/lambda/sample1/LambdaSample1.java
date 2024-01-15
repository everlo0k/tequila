package cn.bigears.lambda.sample1;

/**
 * LambdaSample1
 * @author shenyang
 * @date 2024-01-15
 */
public class LambdaSample1 {

    public OrderFactoryCustomizer<OcrOrderFactory> customizer() {
        return (factory) -> {
            factory.show(3);
        };
    }

    public static void main(String[] args) {
        LambdaSample1 lambdaSample1 = new LambdaSample1();
        OrderFactoryCustomizer<OcrOrderFactory> customizer = lambdaSample1.customizer();
        OcrOrderFactory ocrOrderFactory = new OcrOrderFactory();
        customizer.customize(ocrOrderFactory);
    }

}
