package cn.bigears.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AspectJXmlDemo
 * @author shenyang
 * @date 2023-12-11
 */
@Aspect
@Configuration
public class AspectJXmlDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();

        applicationContext.setConfigLocation("classpath:/META-INF/spring-aop-context.xml");

        applicationContext.close();

    }

}
