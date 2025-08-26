package cn.bigears.pattern.chain.annotation;

import java.lang.annotation.*;

/**
 * Length
 * @author shenyang
 * @date 2025-08-26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Length {

    int value();

}
