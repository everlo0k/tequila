package cn.bigears.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CircularServiceOne
 * @author shenyang
 * @date 2024-08-21
 */
@Component
public class CircularServiceOne {

    @Autowired
    private CircularServiceTwo circularServiceTwo;

    // public CircularServiceOne(CircularServiceTwo circularServiceTwo) {
    //     this.circularServiceTwo = circularServiceTwo;
    // }

    public void one() {
        System.out.println(circularServiceTwo);
    }
}
