package cn.sepiggy.method_invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射完成方法调用
 */
public class MethodInvoke {

    public static void main(String[] args) {
        // 获取 Foo 类的 print(int, int) 方法:

        // 1. 要获取一个方法就是获取类的信息, 而获取类的信息就是获取这个类的 class type.
        Foo foo = new Foo();
        Class clazz = foo.getClass();

        /**
         * 2. 获取特定的方法, 由方法名称和参数列表决定
         * getMethod 获取的是 public 的方法
         * getDeclaredMethod 获取的是自己声明的方法
         */
        Method method = null;
        try {
            method = clazz.getMethod("print", int.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 3. 利用反射完成方法调用
        try {
            // 这里相当于 foo.print(1, 2)
            Object o = method.invoke(foo, 1, 2);

            // 方法如果没有返回值就返回 null; 有返回值就返回具体的值
            System.out.println("返回值:" + o);

            // method.invoke(foo, "good", "night"); 非法参数异常
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Foo {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + ", " + b.toLowerCase());
    }
}
