package cn.bigears.spring.base.factory.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * FactoryBeanSample1
 * @author shenyang
 * @date 2024-01-16
 */
public class FactoryBeanSample1 {

    @Bean
    public OrderPurchaseManageFactory orderPurchaseManageFactory() {
        return new OrderPurchaseManageFactory();
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FactoryBeanSample1.class);
        applicationContext.refresh();
        OrderPurchaseManageFactory orderPurchaseManageFactory = applicationContext.getBean(OrderPurchaseManageFactory.class);
        System.out.println(orderPurchaseManageFactory.getObject());
        OrderPurchaseManage orderPurchaseManage = applicationContext.getBean(OrderPurchaseManage.class);
        System.out.println(orderPurchaseManage);
        // 按照 orderPurchaseManageFactory 这个名称来获取 bean，实际得到的是 orderPurchaseManage
        Object bean1 = applicationContext.getBean("orderPurchaseManageFactory");
        System.out.println(bean1);
        // 返回 ture
        System.out.println(orderPurchaseManage == bean1);
        // 按照 &orderPurchaseManageFactory 这个名称来获取 bean，才能得到的 orderPurchaseManageFactory
        Object bean2 = applicationContext.getBean("&orderPurchaseManageFactory");
        // 返回 ture
        System.out.println(orderPurchaseManageFactory == bean2);
        applicationContext.close();
    }

}
