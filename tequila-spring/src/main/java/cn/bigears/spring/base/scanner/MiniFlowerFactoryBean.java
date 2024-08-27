package cn.bigears.spring.base.scanner;

import cn.bigears.spring.base.scanner.definition.MiniFlowerInterface;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MiniFlowerFactoryBean
 * @author shenyang
 * @date 2024-08-22
 */
public class MiniFlowerFactoryBean implements FactoryBean<Object> {

    private Class clazz;

    public MiniFlowerFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        Object proxyInstance = Proxy.newProxyInstance(MiniFlowerInterface.class.getClassLoader(), new Class[]{MiniFlowerInterface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("test")) {
                    System.out.println("proxy test");
                    Object o = clazz.newInstance();
                    if (o instanceof MiniFlowerInterface) {
                        ((MiniFlowerInterface) o).test();
                    }
                }
                return null;
            }
        });
        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return MiniFlowerInterface.class;
    }
}
