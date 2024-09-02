package cn.bigears.spring.base.annotation;

import cn.bigears.spring.base.scanner.MiniFlower;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * MainAnnotationMetadata
 * @author shenyang
 * @date 2024-08-27
 */
public class MainAnnotationMetadata {

    public static void main(String[] args) {

        AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(MyMiniFlower.class);
        if (annotationMetadata.hasAnnotation(MiniFlower.class.getName())) {
            // 获取 MiniFlower 注解的属性
            // 底层是基于 AnnotationsScanner 来实现的
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(MiniFlower.class.getName());
            if (annotationAttributes != null) {
                // 输出注解的属性值
                System.out.println(annotationAttributes.get("value"));
            }
        } else {
            System.out.println("MyMiniFlower does not have annotation MiniFlower.");
        }

    }

}
