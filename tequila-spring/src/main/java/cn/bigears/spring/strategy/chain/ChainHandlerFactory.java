package cn.bigears.spring.strategy.chain;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ChainHandlerFactory
 * @author shenyang
 * @date 2025-03-26
 */
public class ChainHandlerFactory<T> {

    private ChainHandler<T> chainHandler;

    ChainHandlerFactory(List<ChainHandler<T>> chainHandlerList) {
        if (!CollectionUtils.isEmpty(chainHandlerList)) {
            for (int i = 0; i < chainHandlerList.size() - 1; i++) {
                chainHandlerList.get(i).setNext(chainHandlerList.get(i + 1));
            }
            chainHandler = chainHandlerList.get(0);
        }
    }

    T execute(T t) {
        return chainHandler.handle(t);
    }

}
