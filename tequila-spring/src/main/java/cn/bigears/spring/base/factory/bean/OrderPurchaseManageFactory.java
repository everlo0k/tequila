package cn.bigears.spring.base.factory.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 注入 OrderPurchaseManageFactory 到 Spring 以后，
 * OrderPurchaseManage 也可以通过依赖查找的方式从 Spring 容器中获取
 * @author shenyang
 * @date 2024-01-16
 */
public class OrderPurchaseManageFactory implements FactoryBean<OrderPurchaseManage> {

    private OrderPurchaseManage orderPurchaseManage = new OrderPurchaseManage();

    @Override
    public OrderPurchaseManage getObject() throws Exception {
        return orderPurchaseManage;
    }

    @Override
    public Class<?> getObjectType() {
        return OrderPurchaseManage.class;
    }
}
