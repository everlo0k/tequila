package cn.bigears.spring.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CircularServiceThree
 * @author shenyang
 * @date 2024-08-21
 */
@Component
public class CircularServiceThree {

    @Autowired
    private CircularServiceOne circularServiceOne;

    // public CircularServiceThree(CircularServiceOne circularServiceOne) {
    //     this.circularServiceOne = circularServiceOne;
    // }

    public void three() {
        System.out.println(circularServiceOne);
    }

}
