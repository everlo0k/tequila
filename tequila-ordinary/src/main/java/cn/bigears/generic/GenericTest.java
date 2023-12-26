package cn.bigears.generic;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GenericTest
 * @author shenyang
 * @date 2020/8/19
 */
public class GenericTest {

    private void test1(List<ArrayList<String>[]> list){
    }

    private void test2(List<? extends Number> list){
    }

    @SneakyThrows
    public static void main(String[] args) {
        genericTest1();
        genericTest2();
        genericTest3();
    }

    private static void genericTest3() {
        Map<Integer, String> maps = new HashMap<>(16);
        Type[] types = maps.getClass().getGenericInterfaces();
        ParameterizedType pType = (ParameterizedType) types[0];
        // interface java.util.Map
        System.out.println(pType.getRawType());
    }

    private static void genericTest1() throws NoSuchMethodException {
        Method method = GenericTest.class.getDeclaredMethod("test1", List.class);
        Type[] types = method.getGenericParameterTypes();
        ParameterizedType pType = (ParameterizedType) types[0];
        // 输出java.util.List<java.util.ArrayList<java.lang.String>[]>
        System.out.println(pType.getTypeName());
        Type type = pType.getActualTypeArguments()[0];
        // 输出java.util.ArrayList<java.lang.String>[]
        System.out.println(type);
        // type是Type类型，但直接输出的不是具体Type的五种子类型，而是这五种子类型以及WildcardType具体表现形式
        // 输出sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
        System.out.println(type.getClass().getName());
    }

    private static void genericTest2() throws NoSuchMethodException {
        Method method = GenericTest.class.getDeclaredMethod("test2", List.class);
        Type[] types = method.getGenericParameterTypes();
        ParameterizedType pType = (ParameterizedType) types[0];
        Type type = pType.getActualTypeArguments()[0];
        // 输出? extends java.lang.Number
        System.out.println(type);
        // 输出sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
        System.out.println(type.getClass().getName());
    }


}
