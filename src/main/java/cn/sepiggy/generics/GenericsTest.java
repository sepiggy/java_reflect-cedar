package cn.sepiggy.generics;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射了解泛型的本质
 */
public class GenericsTest {

    @Test
    public void test() {

        ArrayList list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList<>();

        list1.add("hello");
        list1.add(1);

        list2.add("hello");
        // list2.add(1); // 编译错误

        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        /**
         * 反射的操作都是编译之后的操作
         *
         * c1 == c2 的结果返回 true, 说明编译之后集合的泛型是去泛型化的.
         * Java 中集合的泛型, 是为了防止错误输入的, 只在编译阶段有效, 绕过编译就无效了.
         */
        System.out.println("(c1==c2) = " + (c1 == c2));

        // 为了验证上述结论, 我们可以通过方法的反射来绕过编译
        try {
            Method method = c2.getMethod("add", Object.class);
            // 通过反射绕过了编译阶段, 在运行阶段直接调用 list2 的 add 方法,
            // list2 是可以存入整数 1234 的, 即使 list2 被声明为泛型 ArrayList<String>.
            method.invoke(list2, 1234);
            System.out.println("list2 = " + list2);

            // 现在就不能这样遍历了, 产生类型转换异常
            // for (String s : list2) {
            //     System.out.println(s);
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
