package cn.bigears.pattern.chain;

import cn.bigears.pattern.chain.annotation.Length;
import cn.bigears.pattern.chain.annotation.Max;
import cn.bigears.pattern.chain.annotation.Min;

/**
 * User
 * @author shenyang
 * @date 2025-08-26
 */
public class User {

    @Length(3)
    private final String name;

    @Max(18)
    @Min(20)
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
