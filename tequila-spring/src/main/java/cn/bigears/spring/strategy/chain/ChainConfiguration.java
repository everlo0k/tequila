package cn.bigears.spring.strategy.chain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * ChainConfiguration
 * @author shenyang
 * @date 2025-03-26
 */
@Configuration
public class ChainConfiguration {

    @Bean
    public ChainHandlerFactory<MiniFlowers> chainHandlerFactory(List<ChainHandler<MiniFlowers>> chainHandlerList) {
        return new ChainHandlerFactory<>(chainHandlerList);
    }

}
