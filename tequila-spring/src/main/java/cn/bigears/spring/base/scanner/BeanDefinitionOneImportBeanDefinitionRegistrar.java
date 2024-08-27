package cn.bigears.spring.base.scanner;

import cn.bigears.spring.base.definition.BeanDefinitionOne;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * BeanDefinitionOneImportBeanDefinitionRegistrar
 * @author shenyang
 * @date 2024-08-22
 */
public class BeanDefinitionOneImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(BeanDefinitionOne.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("bigears");
        registry.registerBeanDefinition("beanDefinitionOne", beanDefinition);
    }

    


}
