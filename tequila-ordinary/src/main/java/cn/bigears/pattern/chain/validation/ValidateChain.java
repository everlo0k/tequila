package cn.bigears.pattern.chain.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * ValidateChain
 * @author shenyang
 * @date 2025-08-26
 */
public class ValidateChain {

    private final List<ValidatorHandler> handlers = new ArrayList<>();

    public void validate(Object value) throws ValidateException {
        ValidateContext context = new ValidateContext(value);
        while (true) {
            int index = context.getCurrentIndex();
            if (index == handlers.size()) {
                break;
            }
            ValidatorHandler validatorHandler = handlers.get(index);
            validatorHandler.validate(context.getValue(), context);
            if (index == context.getCurrentIndex()) {
                break;
            }
        }
        context.throwExceptionIfNecessary();
    }

    public void addLastHandler(ValidatorHandler handler) {
        this.handlers.add(handler);
    }

}
