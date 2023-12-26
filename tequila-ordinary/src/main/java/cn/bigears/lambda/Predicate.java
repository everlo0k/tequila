package cn.bigears.lambda;

/**
 * Predicate
 * @author shenyang
 * @date 2022/8/24
 */
public interface Predicate<T> extends java.util.function.Predicate<T> {

    @Override
    boolean equals(Object object);

    boolean test2(Object object);

}
