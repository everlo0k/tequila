package cn.bigears.spring.strategy.chain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * OneChainHandler
 * @author shenyang
 * @date 2025-03-26
 */
@Component
@Order(1)
public class OneChainHandler extends ChainHandler<MiniFlowers> {

    @Override
    public MiniFlowers handle(MiniFlowers miniFlowers) {
        miniFlowers.setPredilection("meet");
        if (hasNext()) {
            return next.handle(miniFlowers);
        }
        return miniFlowers;
    }

    @Override
    public void setNext(ChainHandler<MiniFlowers> next) {
        this.next = next;
    }

}
