package cn.bigears.base.proxy;

import java.lang.reflect.*;

/**
 * ProxyTestOne
 * @author shenyang
 * @date 2020/11/2
 */
public class ProxyTestOne {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class calculatorProxyClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);
        Constructor constructor = calculatorProxyClass.getConstructor(InvocationHandler.class);
        Calculator calculatorImpl = (Calculator) constructor.newInstance((InvocationHandler) (proxy, method, args1) -> {
            System.out.println("use proxy");
            CalculatorImpl impl = new CalculatorImpl();
            return method.invoke(impl, args1);
        });
        System.out.println(calculatorImpl.add(1, 2));

        Calculator calculatorProxy = (Calculator) getProxy(new CalculatorImpl());
        System.out.println(calculatorProxy.add(1, 3));
    }


    private static Object getProxy(Object target) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class targetClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor constructor = targetClass.getConstructor(InvocationHandler.class);
        Object proxyObject = constructor.newInstance(
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("use proxy");
                        return method.invoke(target, args);
                    }
                }
        );
        return proxyObject;

    }

}
