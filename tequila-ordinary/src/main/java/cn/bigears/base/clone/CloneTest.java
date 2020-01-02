package cn.bigears.base.clone;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CloneTest
 * @author shenyang
 * @date 2020/1/2
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("1993-01-01");
        BigClone bigClone = new BigClone();
        bigClone.setName("big");
        // 这个时候bigClone中birth的date引用和上面定义的date不是同一个
        // 实际是在setBirth方法执行的时候,new了一个新值传递到方法中
        bigClone.setBirth(date);

        // 浅克隆,两个对象birth属性中实际是引用的同一个date
        BigClone bigClone2 = bigClone.clone();
        bigClone.getBirth().setTime(12345678);
        System.out.println(bigClone.getBirth());
        System.out.println(bigClone2.getBirth());
    }

}

@Data
class BigClone implements Cloneable {
    String name;
    Date birth;

    @Override
    public BigClone clone() throws CloneNotSupportedException {
        return (BigClone) super.clone();
    }

}