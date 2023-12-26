package cn.bigears.lambda;

import java.util.function.Predicate;

/**
 * FastCharMatcher
 * @author shenyang
 * @date 2022/8/24
 */
public class FastCharMatcher extends CharMatcher {

    @Override
    public Predicate<Object> and(Predicate<? super Object> other) {
        return super.and(other);
    }

    @Override
    public Predicate<Object> negate() {
        return super.negate();
    }

    @Override
    public Predicate<Object> or(Predicate<? super Object> other) {
        return super.or(other);
    }

    @Override
    public boolean test2(Object object) {
        return false;
    }
}
