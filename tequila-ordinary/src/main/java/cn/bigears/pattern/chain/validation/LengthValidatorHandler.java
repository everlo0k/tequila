package cn.bigears.pattern.chain.validation;

/**
 * LengthValidatorHandler
 * @author shenyang
 * @date 2025-08-26
 */
public class LengthValidatorHandler implements ValidatorHandler {

    private final int length;

    public LengthValidatorHandler(int length) {
        this.length = length;
    }

    @Override
    public void validate(Object value, ValidateContext validateContext) {
        if (value instanceof String) {
            if (((String) value).length() != length) {
                validateContext.addMessage("你的字符串长度是" + ((String) value).length() + "，应该是" + length);
            }
        }
        validateContext.doNext(value);
    }

}
