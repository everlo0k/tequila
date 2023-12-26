package cn.bigears.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * JoinerTest
 * @author shenyang
 * @date 2022/8/22
 */
public class JoinerTest {

    public static void main(String[] args) {

        List<String> words = Lists.newArrayList("123", "456", "789", null);
        System.out.println(Joiner.on(",").useForNull("default").join(words));
        System.out.println(Joiner.on(",").skipNulls().join(words));

        Map<String, String> data = ImmutableMap.of("a", "1", "b", "2");
        // output:a-1,b-2
        System.out.println(Joiner.on(",").withKeyValueSeparator("-").join(data));
        Map<String, Integer> data2 = ImmutableMap.of("a", 1, "b", 2);
        // output:a-1,b-2
        System.out.println(Joiner.on(",").withKeyValueSeparator("-").join(data2));


    }

}
