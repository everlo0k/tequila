package cn.bigears.spring.base.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * MyService
 * @author shenyang
 * @date 2024-08-23
 */
@Component
// @Configuration
public class MyService {

    @Bean(name = "myBean002")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("002");
        return myBean;
    }

    @PostConstruct
    public void test() {
        MyBean myBean1 = myBean();
        MyBean myBean2 = myBean();
        System.out.println("test " + myBean1 + " name:" + myBean1.getName());
        System.out.println("test " + myBean2 + " name:" + myBean2.getName());
    }

}
