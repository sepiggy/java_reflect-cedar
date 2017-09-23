package cn.sepiggy.dynamic_load_class;

import org.junit.Test;

public class Office {

    @Test
    public void test() {
        load("Word");
        load("Excel");
    }

    private void load(String args) {
        // 使用 new 创建对象是静态加载类, 在编译时刻就需要加载"所有可能"使用到的类, 不管你是否真的用的到.
        // 这样做有弊端:
        // 假如一共有 100 个类, 只要一个类的加载出现问题, 其他 99 个类都不能使用.
        // 我们希望 "用哪个类就加载哪个类, 不用不加载, 用多少加载多少".
        // 通过动态加载类可以达到上述目的.

        if ("Word".equalsIgnoreCase(args)) {
            Word w = new Word();
            w.start();
        }

        // 编译报错
        // if ("Excel".equalsIgnoreCase(args)) {
        //     Excel e = new Excel();
        //     e.start();
        // }
    }
}
