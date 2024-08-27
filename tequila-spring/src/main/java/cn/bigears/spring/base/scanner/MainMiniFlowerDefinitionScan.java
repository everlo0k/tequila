package cn.bigears.spring.base.scanner;

import cn.bigears.spring.base.scanner.definition.MiniFlowerInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 实现自定义注解@MiniFlower的扫描，生产代理对象注册的容器
 * @author shenyang
 * @date 2024-08-22
 */
@MiniFlowerScan("cn.bigears.spring.base.scanner.definition")
public class MainMiniFlowerDefinitionScan {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MainMiniFlowerDefinitionScan.class);

        applicationContext.refresh();

        MiniFlowerInterface miniFlowerInterface = applicationContext.getBean("miniFlowerInterfaceTwo", MiniFlowerInterface.class);

        miniFlowerInterface.test();

        applicationContext.close();
    }

}
