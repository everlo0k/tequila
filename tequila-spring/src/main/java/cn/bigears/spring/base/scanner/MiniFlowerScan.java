package cn.bigears.spring.base.scanner;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MiniFlower
 * @author shenyang
 * @date 2024-08-22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MiniFlowerImportBeanDefinitionRegistrar.class)
public @interface MiniFlowerScan {

    String value() default "";


}
