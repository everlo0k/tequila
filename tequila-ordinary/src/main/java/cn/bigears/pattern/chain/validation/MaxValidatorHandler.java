package cn.bigears.pattern.chain.validation;

/**
 * MaxValidatorHandler
 * @author shenyang
 * @date 2025-08-26
 */
public class MaxValidatorHandler implements ValidatorHandler {

    private final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }

    @Override
    public void validate(Object value, ValidateContext validateContext) {
        if (value instanceof Integer) {
            if ((Integer) value > max) {
                validateContext.addMessage("你的值是" + value + "不能大于" + max);
            }
        }
        validateContext.put("name", "bigears");
        validateContext.doNext(value);
    }

}
