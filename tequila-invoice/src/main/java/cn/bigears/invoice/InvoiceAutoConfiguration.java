package cn.bigears.invoice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * InvoiceAutoConfiguration
 * @author shenyang
 * @date 2024-09-26
 */
@Configuration
public class InvoiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(InvoiceService.class)
    public InvoiceService invoiceService(){
        return new CommonInvoiceService();
    }

}
