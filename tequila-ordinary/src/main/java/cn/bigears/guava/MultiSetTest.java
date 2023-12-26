package cn.bigears.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

import java.util.List;

/**
 * MultiSetTest
 * @author shenyang
 * @date 2022/8/24
 */
public class MultiSetTest {

    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("A", "A", "B", "B", "C", "D");
        Multiset<String> multiset = HashMultiset.create();
        multiset.addAll(words);
        System.out.println(multiset);
        System.out.println(multiset.count("A"));

    }

}
