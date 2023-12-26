package cn.bigears.spring.aop.features;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AspectJAnnotationDemo
 * @author shenyang
 * @date 2023-12-11
 */
@Aspect
@Configuration
@EnableAspectJAutoProxy
public class AspectJAnnotationDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AspectJAnnotationDemo.class);

        applicationContext.refresh();

        AspectJAnnotationDemo aspectJAnnotationDemo = applicationContext.getBean(AspectJAnnotationDemo.class);

        System.out.println(aspectJAnnotationDemo);

        applicationContext.close();
    }

}
