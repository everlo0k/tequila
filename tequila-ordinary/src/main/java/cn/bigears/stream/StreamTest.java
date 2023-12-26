package cn.bigears.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * StreamTest
 * @author shenyang
 * @date 2022/8/25
 */
public class StreamTest {

    @Data
    @AllArgsConstructor
    private class Admin {
        String id;
        String name;
        Integer age;
    }

    private List<Admin> getList() {
        List<Admin> adminList = new ArrayList<>();
        Admin one = new Admin("1", "one", 1);
        Admin two = new Admin("2", "two", 2);
        Admin three = new Admin("3", "three", 3);
        adminList.add(one);
        adminList.add(two);
        adminList.add(three);
        return adminList;
    }

    private void testGroupingBy(List<Admin> adminList) {
        Map<String, List<Admin>> adminMap = adminList.stream().collect(Collectors.groupingBy(Admin::getId));
        System.out.println(adminMap);
    }

    private void testToMap(List<Admin> adminList) {
        Map<String, String> adminMap = adminList.stream().collect(Collectors.toMap(Admin::getId, Admin::getName));
        System.out.println(adminMap);
    }

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.testGroupingBy(streamTest.getList());
        streamTest.testToMap(streamTest.getList());

        System.out.println(streamTest.getList().stream().filter(item -> item.getAge() > 1).count());
        System.out.println(streamTest.getList().parallelStream().filter(item -> item.getAge() > 1).count());
    }

}
