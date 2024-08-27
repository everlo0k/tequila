package cn.bigears.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CircularServiceTwo
 * @author shenyang
 * @date 2024-08-21
 */
@Component
public class CircularServiceTwo {

    @Autowired
    private CircularServiceOne circularServiceOne;

    @Autowired
    private CircularServiceThree circularServiceThree;

    // public CircularServiceTwo(CircularServiceOne circularServiceOne, CircularServiceThree circularServiceThree) {
    //     this.circularServiceOne = circularServiceOne;
    //     this.circularServiceThree = circularServiceThree;
    // }

    public void two() {
        System.out.println(circularServiceOne);
        System.out.println(circularServiceThree);
    }

}
