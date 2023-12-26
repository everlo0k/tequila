package cn.bigears.spring.aop.features.advisor;

import cn.bigears.spring.aop.overview.EchoService;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;

/**
 * DefaultIntroductionAdvisor
 * 如果我们的类实现多个接口，而我们只想针对其中一些进行代理增强
 * @author shenyang
 * @date 2023-12-12
 */
public class IntroductionAdvisorDemo implements EchoService, ReadService {

    public static void main(String[] args) {
        IntroductionAdvisorDemo demo = new IntroductionAdvisorDemo();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(demo);
        proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("BeforeAdvice : " + method);
            }
        }, new IntroductionInfo() {
            @Override
            // 仅仅代理EchoService接口
            public Class<?>[] getInterfaces() {
                return new Class[]{EchoService.class};
            }
        }));
        // 代理EchoService
        EchoService proxyEcho = (EchoService) proxyFactory.getProxy();
        proxyEcho.echo("11");
        // 报错com.sun.proxy.$Proxy0 cannot be cast to cn.bigears.spring.aop.features.advisor.ReadService
        ReadService proxyRead = (ReadService) proxyFactory.getProxy();
        proxyRead.read();
    }

    @Override
    public void read() {
        System.out.println("I am reading.");
    }

    @Override
    public String echo(String message) throws NullPointerException {
        System.out.println("echoing.");
        return null;
    }

}
