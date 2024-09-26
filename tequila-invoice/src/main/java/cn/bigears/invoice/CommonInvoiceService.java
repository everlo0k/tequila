package cn.bigears.invoice;

/**
 * CommonInvoiceService
 * @author shenyang
 * @date 2024-09-26
 */
public class CommonInvoiceService implements InvoiceService{
    @Override
    public void push() {
        System.out.println("push");
    }
}
