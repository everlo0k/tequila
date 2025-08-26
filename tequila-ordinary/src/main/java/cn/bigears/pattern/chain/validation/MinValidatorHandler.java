package cn.bigears.pattern.chain.validation;

/**
 * MinValidatorHandler
 * @author shenyang
 * @date 2025-08-26
 */
public class MinValidatorHandler implements ValidatorHandler {

    private final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }

    @Override
    public void validate(Object value, ValidateContext validateContext) {
        Object name = validateContext.get("name");
        if (name != null) {
            System.out.println("haha " + name + "校验过");
        }
        if (value instanceof Integer) {
            if ((Integer) value < min) {
                validateContext.addMessage("你的值是" + value + "不能小于" + min);
            }
        }
        validateContext.doNext(value);
    }

}
