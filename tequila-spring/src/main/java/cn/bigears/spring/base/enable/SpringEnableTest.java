package cn.bigears.spring.base.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

/**
 * 通过 enable 注解，实现导入 Bean
 * 实际在 org.springframework.context.annotation.ConfigurationClassParser#processImports 中实例化
 * @see ConfigurationClassPostProcessor
 * @author shenyang
 * @date 2023-12-28
 */
@EnableHello
public class SpringEnableTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class
        context.register(SpringEnableTest.class);

        // 如果不注册 Configuration Class，可以配置扫描，并配置 @Configuration
        // context.scan("cn.bigears.spring.base");

        context.refresh();

        System.out.println(context.getBean("hello"));

        context.close();

    }


}
