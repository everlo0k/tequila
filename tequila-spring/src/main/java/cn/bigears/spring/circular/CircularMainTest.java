package cn.bigears.spring.circular;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * CircularMainTest
 * @author shenyang
 * @date 2024-08-21
 */
@ComponentScan
public class CircularMainTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircularMainTest.class);

        CircularServiceOne circularServiceOne = context.getBean(CircularServiceOne.class);
        circularServiceOne.one();

        CircularServiceTwo circularServiceTwo = context.getBean(CircularServiceTwo.class);
        circularServiceTwo.two();

        CircularServiceThree circularServiceThree = context.getBean(CircularServiceThree.class);
        circularServiceThree.three();

        context.close();

    }

}
