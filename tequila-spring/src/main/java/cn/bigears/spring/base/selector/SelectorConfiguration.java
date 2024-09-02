package cn.bigears.spring.base.selector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SelectorConfiguration
 * @author shenyang
 * @date 2024-08-30
 */
@Configuration
public class SelectorConfiguration {

    @Bean
    public SelectorBean selectorBean(){
        SelectorBean selectorBean = new SelectorBean();
        selectorBean.setName("selector");
        return selectorBean;
    }
}
