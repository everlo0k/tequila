package cn.bigears.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyTestTwo
 * @author shenyang
 * @date 2020/11/3
 */
public class ProxyTestTwo {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = (Calculator) getProxy(calculator);
        System.out.println(proxy.add(1, 2));

    }

    private static Object getProxy(Object target) {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("do proxy");
                return method.invoke(target,args);
            }
        });
        return proxy;
    }


}
