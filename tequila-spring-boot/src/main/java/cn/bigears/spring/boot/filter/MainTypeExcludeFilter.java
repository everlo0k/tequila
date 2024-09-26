package cn.bigears.spring.boot.filter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;






/**
 * MainTypeExcludeFilter
 * @author shenyang
 * @date 2024-09-02
 */
// @ComponentScan(value = "cn.bigears.spring.boot.bean", excludeFilters = {
//         @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeExcludeFilter.class})})
// 这样配置，原有的TypeExcludeFilter就失去作用了

// @Import(MyFilterImportSelector.class)
// 想通过import导入，但是这样不行，因为在ConfigurationClassPostProcessor执行import的时候，扫描已经完成了

@SpringBootApplication(scanBasePackages = "cn.bigears.spring.boot.bean")
public class MainTypeExcludeFilter {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MainTypeExcludeFilter.class).run();
        System.out.println(applicationContext.containsBean("erden"));
        System.out.println(applicationContext.containsBean("ring"));
        System.out.println(applicationContext.containsBean("cn.bigears.spring.boot.filter.MyTypeExcludeFilter"));
        applicationContext.close();
    }

}

