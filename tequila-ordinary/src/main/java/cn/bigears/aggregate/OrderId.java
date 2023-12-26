package cn.bigears.aggregate;

/**
 * OrderId
 * @author shenyang
 * @date 2022/8/16
 */
public class OrderId implements Identifier {

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
