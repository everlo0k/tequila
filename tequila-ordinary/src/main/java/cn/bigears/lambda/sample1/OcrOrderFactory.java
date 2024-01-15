package cn.bigears.lambda.sample1;

/**
 * OcrOrderFactory
 * @author shenyang
 * @date 2024-01-15
 */
public class OcrOrderFactory implements OrderFactory {

    void show(int num) {
        System.out.println("Ocr Order,num:" + num);
    }

}
