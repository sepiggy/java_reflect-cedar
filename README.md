Demos for [反射 --- Java高级开发必须懂的](http://www.imooc.com/learn/199)

# Java-Reflect 专题
## Class类的使用
1. 通过 `class type` 可以获取类的信息, 包括 `成员变量`, `成员方法`, `构造器` 等.

2. 获取  `class type` 有三种方法: 
- `Class clazz = int.class;`
-  `String s = new String(); Class clazz = s.getClass();`
- `Class.forName("java.lang.String")`

## 利用反射完成方法调用
1. 如何获取某个方法
`方法的名称和方法的参数列表才能唯一决定某个方法`
2. 方法反射的操作
`Method.invoke(对象, 参数列表)`

## Java类加载机制
`Class.forName("类的全称")`
1. 不仅表示了类的 class type, 还代表了动态加载类
2. 请大家区分编译, 运行
3. 编译时刻加载类是静态加载类, 运行时刻加载类是动态加载类

## 通过反射了解集合泛型的本质
