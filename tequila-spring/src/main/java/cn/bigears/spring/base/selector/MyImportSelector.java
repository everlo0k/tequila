package cn.bigears.spring.base.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 通过类的全限定名注册Bean
 * @author shenyang
 * @date 2024-08-30
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{SelectorBean.class.getName()};
    }
}
