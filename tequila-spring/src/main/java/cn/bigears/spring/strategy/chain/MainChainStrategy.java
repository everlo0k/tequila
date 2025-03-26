package cn.bigears.spring.strategy.chain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 实现一个简单的责任链模式
 * 通过工厂创建一个 Handler 链
 * @author shenyang
 * @date 2025-03-26
 */
@ComponentScan("cn.bigears.spring.strategy.chain")
public class MainChainStrategy {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MainChainStrategy.class);

        applicationContext.refresh();

        ChainHandlerFactory<MiniFlowers> bean = applicationContext.getBean(ChainHandlerFactory.class);

        MiniFlowers miniFlowers = bean.execute(new MiniFlowers());

        System.out.println(miniFlowers.getPredilection());

        applicationContext.close();
    }

}
