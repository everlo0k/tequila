package cn.bigears.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 * @author shenyang
 * @date 2025-11-18
 */
@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello，我是用户服务";
    }

}
