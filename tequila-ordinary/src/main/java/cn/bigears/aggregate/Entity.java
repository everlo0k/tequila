package cn.bigears.aggregate;

/**
 * Entity,实体类的 Marker 接口
 * @author shenyang
 * @date 2022/8/16
 */
public interface Entity<ID extends Identifier> extends Identifiable<ID> {
}
