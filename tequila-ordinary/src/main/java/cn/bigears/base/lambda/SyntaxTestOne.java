package cn.bigears.base.lambda;

/**
 * SyntaxTestOne 基本语法测试
 * @author shenyang
 * @date 2019/12/30
 */
public class SyntaxTestOne {

    public static void main(String[] args) {
        // 通过接口实现类调用
        StringCompare stringCompareOne = new StringCompareImpl();
        System.out.println("stringCompareOne:" + stringCompareOne.compare("bigears", "flowers"));

        // 通过匿名内部类调用
        StringCompare stringCompareTwo = new StringCompare() {
            @Override
            public boolean compare(String s1, String s2) {
                return false;
            }
        };

        // 使用lambda表达式
        // ():表示形参
        // {}:表示方法体
        // ->:lambda运算符，读作goes to
        StringCompare stringCompareThree = (s1, s2) -> {
            if (s1 == null && s2 == null) {
                return true;
            }
            if (s1 == null) {
                return false;
            }
            return s1.equals(s2);
        };

        // 如果只有一行代码(忽略s1为空的情况),可以省略大括号和return
        StringCompare stringCompareFour = (s1, s2) -> s1.equals(s2);

        // replaced with method reference
        StringCompare stringCompareFive = String::equals;

    }

    static class StringCompareImpl implements StringCompare {
        @Override
        public boolean compare(String s1, String s2) {
            if (s1 == null && s2 == null) {
                return true;
            }
            if (s1 == null) {
                return false;
            }
            return s1.equals(s2);
        }
    }

    @FunctionalInterface
    interface StringCompare {
        /**
         * 比较两个字符串是否相等
         * @param s1 字符串1
         * @param s2 字符串2
         * @return 等:true,不等:false
         */
        boolean compare(String s1, String s2);

    }


}


