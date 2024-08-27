package cn.bigears.spring.base.definition;

/**
 * BeanDefinitionOne
 * @author shenyang
 * @date 2024-08-22
 */
public class BeanDefinitionOne {

    private String name;

    public BeanDefinitionOne(String name) {
        this.name = name;
    }

    public void test() {
        System.out.println(name);
    }

}
