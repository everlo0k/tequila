package cn.bigears.spring.boot.factories;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * SpiServiceFactory
 * @author shenyang
 * @date 2024-09-27
 */
public class SpiServiceFactory implements InitializingBean {

    private SpiService spiService;

    @Override
    public void afterPropertiesSet() {
        List<SpiService> list = SpringFactoriesLoader.loadFactories(SpiService.class, null);
        if (!CollectionUtils.isEmpty(list)) {
            spiService = list.get(0);
        }
    }

    SpiService getSpiService() {
        return spiService;
    }
}
