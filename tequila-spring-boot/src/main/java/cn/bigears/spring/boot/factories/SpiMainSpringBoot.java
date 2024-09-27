package cn.bigears.spring.boot.factories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * SpiMainSpringBoot
 * @author shenyang
 * @date 2024-09-27
 */
@SpringBootApplication
public class SpiMainSpringBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpiMainSpringBoot.class, args);
        SpiServiceFactory spiServiceFactory = applicationContext.getBean(SpiServiceFactory.class);
        SpiService spiService = spiServiceFactory.getSpiService();
        if (spiService != null) {
            spiService.spi();
        }
        applicationContext.close();
    }

    @Bean
    public SpiServiceFactory spiServiceFactory() {
        return new SpiServiceFactory();
    }
}
