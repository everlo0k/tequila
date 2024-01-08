package cn.bigears.base.extend;

/**
 * 类方法的查找，本类中没有的话，优先查找超类，最后是接口中的实现
 * @author shenyang
 * @date 2024-01-04
 */
public class DefaultBase extends BaseSupport implements BaseInterface {

    public static void main(String[] args) {
        DefaultBase base = new DefaultBase();
        base.testExtend();
    }

}
