package cn.bigears.spring.aop.features;

import cn.bigears.spring.aop.features.interceptor.EchoServiceMethodInterceptor;
import cn.bigears.spring.aop.overview.DefaultEchoService;
import cn.bigears.spring.aop.overview.EchoService;
import org.springframework.aop.framework.ProxyFactory;

/**
 * ProxyFactory
 * 脱离Spring容器，使用ProxyFactory代理接口
 * 效果同ProxyFactoryBeanDemo
 * ProxyFactory和AspectJProxyFactor都extends ProxyCreatorSupport
 * ProxyFactory基于接口代理
 * AspectJProxyFactor支持直接addAspect
 * @author shenyang
 * @date 2023-12-11
 */
public class ProxyFactoryDemo {

    public static void main(String[] args) {
        DefaultEchoService defaultEchoService = new DefaultEchoService();
        // 注入目标对象（被代理）
        ProxyFactory proxyFactory = new ProxyFactory(defaultEchoService);
        // 添加 Advice 实现 MethodInterceptor < Interceptor < Advice
        proxyFactory.addAdvice(new EchoServiceMethodInterceptor());
        // 获取代理对象
        EchoService echoService = (EchoService) proxyFactory.getProxy();
        System.out.println(echoService.echo("Hello,World"));
    }
}