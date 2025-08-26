package cn.bigears.pattern.chain.validation;

/**
 * ValidatorHandler
 * @author shenyang
 * @date 2025-08-26
 */
public interface ValidatorHandler {

    /**
     * 校验
     * @param value 校验对象
     * @param validateContext 上下文
     * @throws ValidateException 校验异常
     */
    void validate(Object value, ValidateContext validateContext) throws ValidateException;

}
