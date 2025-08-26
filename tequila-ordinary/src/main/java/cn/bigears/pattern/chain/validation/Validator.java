package cn.bigears.pattern.chain.validation;

import cn.bigears.pattern.chain.annotation.Length;
import cn.bigears.pattern.chain.annotation.Max;
import cn.bigears.pattern.chain.annotation.Min;

import java.lang.reflect.Field;

/**
 * Validator
 * @author shenyang
 * @date 2025-08-26
 */
public class Validator {

    public void validate(Object object) throws Exception {
        Class<?> beanClass = object.getClass();
        for (Field field : beanClass.getDeclaredFields()) {
            field.setAccessible(true);
            ValidateChain validateChain = bulidValidateChain(field);
            validateChain.validate(field.get(object));
        }
    }

    private ValidateChain bulidValidateChain(Field field) {
        ValidateChain validateChain = new ValidateChain();
        Max max = field.getAnnotation(Max.class);
        if (max != null) {
            validateChain.addLastHandler(new MaxValidatorHandler(max.value()));
        }
        Min min = field.getAnnotation(Min.class);
        if (min != null) {
            validateChain.addLastHandler(new MinValidatorHandler(min.value()));
        }
        Length length = field.getAnnotation(Length.class);
        if (length != null) {
            validateChain.addLastHandler(new LengthValidatorHandler(length.value()));
        }
        return validateChain;
    }

}
