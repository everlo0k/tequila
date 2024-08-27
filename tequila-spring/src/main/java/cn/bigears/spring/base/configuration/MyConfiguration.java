package cn.bigears.spring.base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyConfiguration
 * @author shenyang
 * @date 2024-08-23
 */
@Configuration
public class MyConfiguration {

    @Bean(name = "myBean001")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("001");
        return myBean;
    }

}
