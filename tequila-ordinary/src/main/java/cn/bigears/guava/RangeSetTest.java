package cn.bigears.guava;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;

/**
 * RangeSetTest
 * @author shenyang
 * @date 2022/8/24
 */
public class RangeSetTest {

    public static void main(String[] args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        // 闭区间 [1,10]
        rangeSet.add(Range.closed(1, 10));
        // 左闭右开区间 [11,15) 如果左边为11 则和上边的区间为不连续区间  如果左边为10 则两个区间进行合并
        rangeSet.add(Range.closedOpen(11, 15));
        // 返回包含指定元素的区间，如果没有这样的区间则返回null
        Range<Integer> integerRange = rangeSet.rangeContaining(5);
        // 返回包含rangeSet 所有区间的最小区间
        Range<Integer> span = rangeSet.span();
        System.out.println(integerRange);
        System.out.println(span);
    }

}
