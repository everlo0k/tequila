package cn.bigears.spring.strategy.chain;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TwoChainHandler
 * @author shenyang
 * @date 2025-03-26
 */
@Component
@Order(2)
public class TwoChainHandler extends ChainHandler<MiniFlowers>{

    @Override
    public MiniFlowers handle(MiniFlowers miniFlowers) {
        miniFlowers.setPredilection("pineapple");
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
