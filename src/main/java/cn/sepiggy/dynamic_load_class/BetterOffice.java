package cn.sepiggy.dynamic_load_class;

import org.junit.Test;

public class BetterOffice {

    @Test
    public void test1() {
        load("cn.sepiggy.dynamic_load_class.Word");
        load("cn.sepiggy.dynamic_load_class.Excel"); // 报异常
    }

    private void load(String args) {
        try {
            // 动态加载类, 在运行时刻加载
            Class c = Class.forName(args);

            // 通过 class type 创建该类对象:
            // 在编码的时候是不知道这个类究竟是啥,
            // 因此引入面向接口编程的思想, 使所有的类都实现 OfficeAble 接口,
            // 这样我们不用知道这个类具体是什么, 只要将其转换为这个接口就可以了.
            OfficeAble oa = null;
            try {
                oa = (OfficeAble) c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            oa.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
