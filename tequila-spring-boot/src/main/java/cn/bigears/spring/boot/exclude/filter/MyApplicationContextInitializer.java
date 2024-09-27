package cn.bigears.spring.boot.exclude.filter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;

/**
 * MyApplicationContextInitializer
 * @author shenyang
 * @date 2024-09-02
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        applicationContext.addBeanFactoryPostProcessor(new TypeExcludeFilterPostProcessor());
    }

    private static class TypeExcludeFilterPostProcessor implements PriorityOrdered, BeanDefinitionRegistryPostProcessor {

        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            registry.registerBeanDefinition("myTypeExcludeFilter", new RootBeanDefinition(MyTypeExcludeFilter.class));
        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        }

        @Override
        public int getOrder() {
            return HIGHEST_PRECEDENCE;
        }
    }

}
