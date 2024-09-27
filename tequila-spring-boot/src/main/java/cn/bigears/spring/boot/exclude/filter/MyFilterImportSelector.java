package cn.bigears.spring.boot.exclude.filter;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 导入的Bean的名字是类的全限定名
 */
public class MyFilterImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{MyTypeExcludeFilter.class.getName()};
    }
}
