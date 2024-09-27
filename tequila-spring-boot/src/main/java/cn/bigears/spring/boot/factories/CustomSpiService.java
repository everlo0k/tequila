package cn.bigears.spring.boot.factories;

/**
 * CustomSpiService
 * @author shenyang
 * @date 2024-09-27
 */
public class CustomSpiService implements SpiService{
    @Override
    public void spi() {
        System.out.println("custom");
    }
}
