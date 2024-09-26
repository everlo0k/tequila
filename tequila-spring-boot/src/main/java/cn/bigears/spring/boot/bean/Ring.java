package cn.bigears.spring.boot.bean;

import org.springframework.stereotype.Component;

/**
 * Ring
 * @author shenyang
 * @date 2024-09-02
 */
@Component
public class Ring {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printName(){
        System.out.println(name);
    }
}
