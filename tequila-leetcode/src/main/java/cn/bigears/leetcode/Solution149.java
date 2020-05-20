package cn.bigears.leetcode;

import java.math.BigDecimal;
import java.util.*;

/**
 * Solution149
 * @author shenyang
 * @date 2020/5/19
 */
public class Solution149 {

    private static class Point implements Comparable {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Point) {
                Point other = (Point) o;
                if (this.x < other.getX()) {
                    return -1;
                } else if (this.x > other.getX()) {
                    return 1;
                }
                if (this.y < other.getY()) {
                    return -1;
                } else if (this.y > other.getY()) {
                    return 1;
                }
            }
            return 1;
        }
    }

    /**
     * 核心的思想是比较两点之间的斜率
     * 特殊的情况:
     * 1.有相同的点
     * 2.x=0,不能除,单独统计
     */
    private static int maxPoints(int[][] points) {
        int smallPointSize = 2;
        if (points.length <= smallPointSize) {
            return points.length;
        }

        Set<Point> set = new TreeSet<>();
        for (int[] point : points) {
            set.add(new Point(point[0], point[1]));
        }
        List<Point> list = new LinkedList<>(set);
        int size = list.size();
        int maxSomeSlope = 0, temp;
        int same;
        int illegal;
        for (int i = 0; i < size; i = i + same + 1) {
            same = 0;
            temp = 0;
            illegal = 0;
            // key为斜率,value该斜率对应的两点连线的数量
            Map<BigDecimal, Integer> map = new HashMap<>(16);
            Point a = list.get(i);
            for (int j = i + 1; j < size; j++) {
                Point c = list.get(j);
                if (a.equals(c)) {
                    // 记录相同的点
                    same++;
                } else {
                    if (c.getX() - a.getX() == 0) {
                        // 记录不能除的数据
                        illegal++;
                    } else {
                        // 这里不能使用Math.atan2方法,精度有问题
                        BigDecimal bigDecimalY = new BigDecimal(String.valueOf(c.getY() - a.getY()));
                        BigDecimal bigDecimalX = new BigDecimal(String.valueOf(c.getX() - a.getX()));
                        BigDecimal slope = bigDecimalY.divide(bigDecimalX, 30, BigDecimal.ROUND_HALF_UP);
                        map.merge(slope, 1, Integer::sum);
                        temp = Math.max(temp, map.get(slope));
                    }
                    temp = Math.max(temp, illegal);
                }
            }
            maxSomeSlope = Math.max(maxSomeSlope, temp + same);
            if (maxSomeSlope >= size - i - 1) {
                break;
            }
        }
        return maxSomeSlope + 1;
    }

    public static void main(String[] args) {
        int[][] points1 = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int[][] points2 = new int[][]{{1, 1}, {2, 2}, {-2, -2}};
        int[][] points3 = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        int[][] points4 = new int[][]{{-5, -4}, {-3, -3}, {1, 1}, {1, 1}, {1, 1}, {4, 4}, {5, 4}};
        int[][] points5 = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        int[][] points6 = new int[][]{{0, 0}, {94911151, 94911150}, {94911152, 94911151}};
        System.out.println(maxPoints(points1));
        System.out.println(maxPoints(points2));
        System.out.println(maxPoints(points3));
        System.out.println(maxPoints(points4));
        System.out.println(maxPoints(points5));
        System.out.println(maxPoints(points6));

    }

}
