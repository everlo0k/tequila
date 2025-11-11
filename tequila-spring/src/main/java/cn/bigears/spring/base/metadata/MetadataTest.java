package cn.bigears.spring.base.metadata;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * MetadataTest
 * @author shenyang
 * @date 2025-11-11
 */
public class MetadataTest {

    public static void main(String[] args) throws IOException {

        ClassMetadata classMetadata = AnnotationMetadata.introspect(MetadataTest.class);
        System.out.println(classMetadata.getClassName());

        SimpleMetadataReaderFactory simpleMetadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = simpleMetadataReaderFactory.getMetadataReader("cn.bigears.spring.base.metadata.MetadataTest");
        ClassMetadata classMetadata2 = metadataReader.getClassMetadata();
        System.out.println(classMetadata2.getClassName());

    }

}
