package cn.bigears.generator;

import java.util.Arrays;
import java.util.List;

/**
 * SeqTest
 * @author shenyang
 * @date 2023/4/12
 */
public class SeqTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Seq<Integer> seq = list::forEach;

    }

}
