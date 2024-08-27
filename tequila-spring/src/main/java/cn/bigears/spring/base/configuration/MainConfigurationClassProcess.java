package cn.bigears.spring.base.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * MainAddBeanDefinition
 * @author shenyang
 * @date 2024-08-22
 */
@ComponentScan("cn.bigears.spring.base.configuration")
public class MainConfigurationClassProcess {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MainConfigurationClassProcess.class);

        applicationContext.refresh();

        MyConfiguration myConfiguration = applicationContext.getBean( MyConfiguration.class);
        MyBean myBean001 = applicationContext.getBean("myBean001", MyBean.class);
        System.out.println(myBean001 + " name:" + myBean001.getName());
        MyBean myBean002 = applicationContext.getBean("myBean002", MyBean.class);
        System.out.println(myBean002 + " name:" + myBean002.getName());
        MyBean myBean003 = applicationContext.getBean("myBean002", MyBean.class);
        System.out.println(myBean003 + " name:" + myBean003.getName());

        applicationContext.close();
    }

}
