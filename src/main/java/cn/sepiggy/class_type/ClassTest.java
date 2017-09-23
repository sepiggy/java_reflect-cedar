package cn.sepiggy.class_type;

import org.junit.Test;


/**
 * Class 类
 * <p>
 * 1. Java中, 静态的成员不是对象; 除这两者之外, 万事万物皆对象.
 * <p>
 * 2. 类也是对象, 类是 java.lang.Class 类的实例对象, 这个对象称为该类的类类型 (class type).
 * <p>
 * 3. 类这个对象如何表示?
 * There is a class named Class.
 */
public class ClassTest {

    /**
     * 获取一个类的类类型的三种方法
     *
     * @throws ClassNotFoundException the class not found exception
     */
    @Test
    public void test1() throws ClassNotFoundException {
        // foo 表示 cn.sepiggy.class_type.Foo 类的一个实例对象, 可以通过 new 操作符获取
        Foo foo = new Foo();

        // c1, c2, c3 分别表示 Class 类的一个实例对象, 这个实例对象代表 cn.sepiggy.class_type.Foo 这个类.
        // 称 c1, c2, c3 表示了 cn.sepiggy.class_type.Foo 类的类类型 (class type)
        // Class 类的实例对象不能通过 new 操作符获取, 因为 Class 类的构造方法是 private.
        // 任何一个类都是 Class 类的实例对象, 这个对象可以通过以下三种方法获取:

        // 1. 通过一个类隐含的静态成员变量 class 来获取
        Class c1 = Foo.class;

        // 2. 通过该类对象的 getClass 方法来获取
        Class c2 = foo.getClass();

        // 3. 通过 Class 类的静态方法 forName 来获取
        Class c3 = Class.forName("cn.sepiggy.class_type.Foo");

        // c1, c2, c3 都代表了 cn.sepiggy.class_type.Foo 类的类类型, 一个类只可能是 Class 类的一个实例对象,
        // 因此 c1, c2 ,c3 都指向同一个对象.
        System.out.println("(c1==c2) = " + (c1 == c2));
        System.out.println("(c2==c3) = " + (c2 == c3));
    }

    /**
     * 通过类的 class type 创建该类的对象实例
     */
    @Test
    public void test2() {
        Class<Foo> fooClass = Foo.class;
        try {
            Foo foo = fooClass.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 普通数据类型也是对象, 也存在class type.
     */
    @Test
    public void test3() {
        // int 的 class type
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = double.class;
        Class c4 = Double.class;
        Class c5 = void.class;

        System.out.println("c1.getName() = " + c1.getName());
        System.out.println("c2.getName() = " + c2.getName());
        System.out.println("c2.getSimpleName() = " + c2.getSimpleName());
        System.out.println("c3.getName() = " + c3.getName());
        System.out.println("c4.getName() = " + c4.getName());
        // c3 和 c4 是不同的 class type
        System.out.println("(c3==c4) = " + (c3==c4));
        System.out.println("c5.getName() = " + c5.getName());
    }
}

class Foo {
    void print() {
        System.out.println("cn.sepiggy.class_type.Foo...");
    }
}