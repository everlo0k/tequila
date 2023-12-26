package cn.bigears.aggregate;

/**
 * Identifiable
 * @author shenyang
 * @date 2022/8/16
 */
public interface Identifiable<ID extends Identifier> {
    /**
     * getId
     * @return ID
     */
    ID getId();
}
