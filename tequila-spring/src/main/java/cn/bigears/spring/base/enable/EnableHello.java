package cn.bigears.spring.base.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * EnableHello
 * @author shenyang
 * @date 2023-12-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(EnableHelloConfiguration.class)
public @interface EnableHello {
}
