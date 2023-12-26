package cn.bigears.generator;

import java.util.function.Consumer;

/**
 * Seq
 * @author shenyang
 * @date 2023/4/12
 */
public interface Seq<T> {

    /**
     * consumer
     * @param consumer consumer
     */
    void consume(Consumer<T> consumer);
}
