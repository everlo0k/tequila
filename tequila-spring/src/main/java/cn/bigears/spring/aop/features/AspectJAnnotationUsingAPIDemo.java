package cn.bigears.spring.aop.features;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.AopContext;

import java.util.HashMap;
import java.util.Map;

/**
 * AspectJProxyFactory
 * 使用org.springframework.aop.aspectj.annotation.AspectJProxyFactory纯代码手写AOP
 * @author shenyang
 * @date 2023-12-11
 */
public class AspectJAnnotationUsingAPIDemo {

    public static void main(String[] args) {

        // 通过创建一个 HashMap 缓存，作为被代理对象
        Map<String, Object> cache = new HashMap<>();
        cache.put("1", "A");
        // 创建 Proxy 工厂(AspectJ)
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(cache);
        // 设置暴露代理对象到 AopContext
        proxyFactory.setExposeProxy(true);
        // 添加 MethodBeforeAdvice
        proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
            if ("put".equals(method.getName()) && args1.length == 2) {
                Object proxy = AopContext.currentProxy();
                System.out.printf("[MethodBeforeAdvice] 当前即将存放是 Key: %s , Value : %s ，" +
                        "当前代理对象：%s\n", args1[0], args1[1], proxy);
            }
        });
        // 添加 AfterReturningAdvice
        proxyFactory.addAdvice((AfterReturningAdvice) (returnValue, method, args12, target) -> {
            if ("put".equals(method.getName()) && args12.length == 2) {
                System.out.printf("[AfterReturningAdvice] 刚刚存放是 Key: %s , 新存放的 Value : %s , 之前关联的 Value : %s\n ",
                        args12[0],    // key
                        args12[1],    // new value
                        returnValue // old value
                );
            }
        });

        Map<String, Object> proxy = proxyFactory.getProxy();
        proxy.put("1", "B");

    }

}
