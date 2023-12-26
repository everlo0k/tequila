package cn.bigears.function;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * FunctionTest
 * @author shenyang
 * @date 2022/8/26
 */
public class FunctionTest {

    private static final int PASS = 60;

    @Data
    @AllArgsConstructor
    private class Student {
        private String name;
        private Integer score;
    }

    private List<Student> getList() {
        int size = 10;
        List<Student> result = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            result.add(new Student(i + "", i * i));
        }
        return result;
    }

    private static class ScoreConsumer implements Consumer<Student> {
        @Override
        public void accept(Student student) {
            if (new ConditionPredicate().test(student)) {
                System.out.println(student.getName() + ":" + student.getScore());
            }
        }
    }

    private static class ConditionPredicate implements Predicate<Student> {
        @Override
        public boolean test(Student student) {
            return student.getScore() < PASS;
        }
    }

    /**
     * 将转换逻辑提取出来
     */
    private static class AddTenScore implements Function<Student, Integer> {
        @Override
        public Integer apply(Student student) {
            return student.getScore() + 10;
        }
    }

    /**
     * 遍历list,同时将处理的逻辑用function的形式,分离出来
     */
    private static int[] listToArray(List<Student> list, Function<Student, Integer> function) {
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++)
            ints[i] = function.apply(list.get(i));
        return ints;
    }

    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.getList().forEach(new ScoreConsumer());
        for (int item : listToArray(functionTest.getList(), new AddTenScore())) {
            System.out.println(item);
        }
    }

}
