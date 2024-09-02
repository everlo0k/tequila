package cn.bigears.spring.boot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User
 * @author shenyang
 * @date 2024-08-29
 */
@ConfigurationProperties(prefix = "user")
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
