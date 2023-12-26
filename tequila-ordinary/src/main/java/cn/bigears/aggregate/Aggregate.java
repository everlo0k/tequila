package cn.bigears.aggregate;

/**
 * Aggregate,聚合根的 Marker 接口
 * @author shenyang
 * @date 2022/8/16
 */
public interface Aggregate<ID extends Identifier> extends Entity<ID> {
}
