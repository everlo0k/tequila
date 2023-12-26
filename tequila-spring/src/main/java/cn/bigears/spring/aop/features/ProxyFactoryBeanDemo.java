package cn.bigears.spring.aop.features;

import cn.bigears.spring.aop.overview.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ProxyFactoryBean
 * 基于Spring IoC容器,通过XML配置ProxyFactoryBean用于代理拦截
 * 并引用一个MethodInterceptor
 * @author shenyang
 * @date 2023-12-11
 */
public class ProxyFactoryBeanDemo {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring-aop-context.xml");

        EchoService echoService = context.getBean("echoServiceProxyFactoryBean", EchoService.class);

        System.out.println(echoService.echo("Hello,World"));

        context.close();
    }

}
