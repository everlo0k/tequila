package cn.bigears.spring.base.enable;

import org.springframework.context.annotation.Bean;

/**
 * EnableHelloConfiguration
 * @author shenyang
 * @date 2023-12-28
 */
public class EnableHelloConfiguration {

    @Bean
    public String hello() {
        return "Hello,Bigears";
    }

}
