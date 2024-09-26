package cn.bigears.common.invoice;

import cn.bigears.invoice.InvoiceService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * MainSpringBoot
 * @author shenyang
 * @date 2024-08-28
 */
@SpringBootApplication
public class MainInvoiceSpringBoot {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MainInvoiceSpringBoot.class)
                .run(args);
        InvoiceService invoiceService = applicationContext.getBean(InvoiceService.class);
        invoiceService.push();
        applicationContext.close();
    }

    /**
     * 如果自定义了一个，则会覆盖默认的CommonInvoiceService
     */
    @Bean
    public InvoiceService invoiceService() {
        return new CustomInvoiceService();
    }

    public class CustomInvoiceService implements InvoiceService {
        @Override
        public void push() {
            System.out.println("custom push");
        }
    }
}
