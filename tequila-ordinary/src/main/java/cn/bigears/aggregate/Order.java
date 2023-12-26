package cn.bigears.aggregate;

/**
 * Order
 * @author shenyang
 * @date 2022/8/16
 */
public class Order implements Aggregate<OrderId> {

    private OrderId orderId;

    @Override
    public OrderId getId() {
        return orderId;
    }


}
