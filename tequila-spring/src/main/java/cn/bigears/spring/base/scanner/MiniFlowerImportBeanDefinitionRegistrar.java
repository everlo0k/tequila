package cn.bigears.spring.base.scanner;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Map;

/**
 * MiniFlowerImportBeanDefinitionRegistrar
 * @author shenyang
 * @date 2024-08-22
 */
public class MiniFlowerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MiniFlowerScan.class.getName());

        String path = (String) annotationAttributes.get("value");

        MiniFlowerScanner miniFlowerScanner = new MiniFlowerScanner(registry);

        miniFlowerScanner.addIncludeFilter(new AnnotationTypeFilter(MiniFlower.class));

        miniFlowerScanner.scan(path);

    }




}
