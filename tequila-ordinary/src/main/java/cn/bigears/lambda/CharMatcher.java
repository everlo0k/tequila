package cn.bigears.lambda;

/**
 * CharMatcher
 * @author shenyang
 * @date 2022/8/24
 */
abstract class CharMatcher implements Predicate<Object> {

    @Override
    public boolean test(Object o) {
        return false;
    }

}
