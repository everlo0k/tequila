package cn.bigears.aggregate;

/**
 * Repository
 * @author shenyang
 * @date 2022/8/16
 */
public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {
    /**
     * find
     * @param id id
     * @return T
     */
    T find(ID id);

}
