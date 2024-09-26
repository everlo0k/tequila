package cn.bigears.spring.boot.filter;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

/**
 * MyTypeExcludeFilter
 * @author shenyang
 * @date 2024-09-02
 */
public class MyTypeExcludeFilter extends TypeExcludeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println(annotationMetadata.getClassName());
        if ("cn.bigears.spring.boot.bean.Ring".equals(annotationMetadata.getClassName())) {
            System.out.println("myTypeExcludeFilter return true");
            return true;
        }
        return false;
    }
}
