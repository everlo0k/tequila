package cn.bigears.guava;

import com.google.common.base.Splitter;

import java.util.Map;

/**
 * SplitterTest
 * @author shenyang
 * @date 2022/8/23
 */
public class SplitterTest {

    public static void main(String[] args) {

        Splitter.on(",").omitEmptyStrings().splitToList("123,456,789,,23").forEach(a -> {
            System.out.println(a);
        });
        Splitter.on(",").limit(2).splitToList("123,456,789,,23").forEach(a -> {
            System.out.println(a);
        });
        Splitter.on(",").trimResults().splitToList("12 3, 456 ,789,,23").forEach(a -> {
            System.out.println(a);
        });
        Map<String, String> map = Splitter.on(",").withKeyValueSeparator("-").split("1-2,3-5");
        System.out.println(map);

    }


}
