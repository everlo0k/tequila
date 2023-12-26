package cn.bigears.generic;

import java.lang.reflect.TypeVariable;

/**
 * GenericTestTwo
 * @author shenyang
 * @date 2020/8/19
 */
public class GenericTestTwo<K extends Number, V> {

    public static void main(String[] args) {
        TypeVariable[] types = GenericTestTwo.class.getTypeParameters();
        for (TypeVariable type : types) {
            // class java.lang.Class
            System.out.println(type.getGenericDeclaration().getClass().getName());
            // K,V
            System.out.println(type.getName());
        }
    }

}
