package cn.bigears.spring.base.post.construct;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * MainPostConstruct
 * @author shenyang
 * @date 2024-08-27
 */
public class MainPostConstruct {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainPostConstruct.class);
        applicationContext.close();
    }

    @PostConstruct
    public void init() {
        System.out.println("init MainPostConstruct");
    }
}
