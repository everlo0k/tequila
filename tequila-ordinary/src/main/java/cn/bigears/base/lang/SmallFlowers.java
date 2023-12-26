package cn.bigears.base.lang;

import java.util.stream.Stream;

/**
 * SmallFlowers
 * @author shenyang
 * @date 2023-12-26
 */
public class SmallFlowers {

    public void say() {
        // 每次调用一个方法会产生一个方法栈
        // 这里获得执行到say()方法涉及的所有过程方法的方法栈,结果如下：
        // class name:cn.bigears.base.lang.SmallFlowers, method name:say
        // class name:cn.bigears.base.lang.StackTraceElementTest$Bigears, method name:smallFlowersSay
        // class name:cn.bigears.base.lang.StackTraceElementTest, method name:main
        StackTraceElement[] stackTraceElements = new RuntimeException().getStackTrace();
        Stream.of(stackTraceElements).forEach(item -> {
            System.out.println("class name:" + item.getClassName() + ", method name:" + item.getMethodName() + "\n");
        });
    }

}
