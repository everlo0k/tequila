package cn.bigears.pattern.chain.annotation;

import java.lang.annotation.*;

/**
 * Max
 * @author shenyang
 * @date 2025-08-26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Min {

    int value();

}
