package cn.bigears.spring.base.selector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Import导入一个配置类
 * @author shenyang
 * @date 2024-08-30
 */
@Import(MyImportSelector.class)
// @Import(SelectorConfiguration.class)
public class MainSelector {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainSelector.class);
        SelectorBean selectorBean = applicationContext.getBean(SelectorBean.class);
        System.out.println(selectorBean);
        System.out.println(selectorBean.getName());
        applicationContext.close();

    }

}
