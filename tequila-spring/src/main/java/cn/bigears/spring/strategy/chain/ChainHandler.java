package cn.bigears.spring.strategy.chain;

/**
 * ChainHandler
 * @author shenyang
 * @date 2025-03-26
 */
public abstract class ChainHandler<T> {

    ChainHandler<T> next;

    T handle(T t) {
        return null;
    }

    boolean hasNext() {
        return next != null;
    }

    public void setNext(ChainHandler<T> next) {
        this.next = next;
    }

}
