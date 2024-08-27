package cn.bigears.spring.base.definition;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MainAddBeanDefinition
 * @author shenyang
 * @date 2024-08-22
 */
public class MainAddBeanDefinition {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(MainAddBeanDefinition.class);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(BeanDefinitionOne.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("bigears");
        applicationContext.registerBeanDefinition("beanDefinitionOne", beanDefinition);

        applicationContext.refresh();

        BeanDefinitionOne beanDefinitionOne = applicationContext.getBean("beanDefinitionOne", BeanDefinitionOne.class);
        beanDefinitionOne.test();

        applicationContext.close();
    }

}
