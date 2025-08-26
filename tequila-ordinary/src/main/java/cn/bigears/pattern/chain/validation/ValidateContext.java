package cn.bigears.pattern.chain.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ValidateContext
 * @author shenyang
 * @date 2025-08-26
 */
public class ValidateContext {

    private final List<String> errorMessages = new ArrayList<>();

    private boolean stop = false;

    private int index = 0;

    private Object value;

    private Map<String, Object> data = new HashMap<>(16);

    public ValidateContext(Object value) {
        this.value = value;
    }

    public void addMessage(String message) {
        errorMessages.add(message);
    }

    public void stopChain() {
        stop = true;
    }

    public boolean shouldStop() {
        return stop;
    }

    public void doNext(Object value) {
        this.value = value;
        index++;
    }

    public int getCurrentIndex() {
        return index;
    }

    public Object getValue() {
        return value;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public void throwExceptionIfNecessary() throws ValidateException {
        if (!errorMessages.isEmpty()) {
            throw new ValidateException(errorMessages.toString());
        }
    }

}
