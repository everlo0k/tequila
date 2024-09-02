package cn.bigears.spring.boot;

import cn.bigears.spring.boot.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * MainSpringBoot
 * @author shenyang
 * @date 2024-08-28
 */
@SpringBootApplication
@PropertySource("classpath:app.properties")
public class MainSpringBoot {

    @Value("${user.nickname}")
    private String name;

    @Value("${user.id}")
    private String id;

    public static void main(String[] args) {
        // ConfigurableApplicationContext applicationContext = SpringApplication.run(MainSpringBoot.class, args);

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(MainSpringBoot.class)
                .profiles("test")
                .run(args);


        MainSpringBoot mainSpringBoot = applicationContext.getBean(MainSpringBoot.class);
        mainSpringBoot.getName();

        User user = applicationContext.getBean(User.class);
        System.out.println(user.getName());

        applicationContext.close();
    }

    public void getName() {
        System.out.println(name + "-" + id);
    }

    @Bean
    public User user() {
        return new User();
    }
}
