package cn.bigears.spring.boot.factories;

/**
 * CommonSpiService
 * @author shenyang
 * @date 2024-09-27
 */
public class CommonSpiService implements SpiService{
    @Override
    public void spi() {
        System.out.println("common");
    }
}
