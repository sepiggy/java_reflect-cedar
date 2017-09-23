package cn.sepiggy.class_type;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class 类的常用 API 操作, 可以用来获取一个类的信息.
 * 要获取一个类的信息, 首先要获取这个类的 class type.
 */
public class ClassUtil {

    /**
     * 打印对象所属类的信息
     *
     * @param obj
     */
    public static void printClassMessage(Object obj) {
        Class clazz = obj.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("该类的全限定名:\n" + clazz.getName());
        sb.append("\n");
        sb.append("该类的简称:\n" + clazz.getSimpleName());
        sb.append("\n");
        System.out.println(sb);
    }

    /**
     * 打印对象成员变量的信息
     * java.lang.reflect.Field 类, 即成员变量对象; 一个成员变量就是一个 Field 对象.
     * Field 对象的获取方法:
     * 1. 通过 Class.getFields() 方法
     * 获取的是所有 public 成员变量, 包括从父类继承的
     * <p>
     * 2. 通过 Class.getDeclaredFields() 方法
     * 获取的是所有该类自己声明的成员变量, 无论任何访问修饰符
     *
     * @param obj
     */
    private static void printFieldMessage(Object obj) {
        Class clazz = obj.getClass();
        System.out.println("该类的成员变量的信息:");
        Field[] fields = clazz.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        for (Field field : fields) {
            // 得到成员变量的 class type
            Class fieldType = field.getType();
            String typeName = fieldType.getName();

            // 得到成员变量的名称
            String fieldName = field.getName();
            sb.append(typeName + " " + fieldName + ";\n");
        }
        System.out.println(sb);
    }

    /**
     * 打印对象成员方法的信息
     * java.lang.reflect.Method 类, 即方法对象; 一个成员方法就是一个 Method 对象.
     * Method 对象的获取方法:
     * 1. 通过 Class.getMethods() 方法
     * 获取的是所有 public 方法, 包括从父类继承而来的
     * <p>
     * 2. 通过 Class.getDeclaredMethods() 方法
     * 获取的是所有该类自己声明的方法, 无论任何访问修饰符
     *
     * @param obj
     */
    private static void printMethodMessage(Object obj) {
        Class clazz = obj.getClass();
        System.out.println("该类的方法信息:");
        Method[] methods = clazz.getDeclaredMethods();
        StringBuffer sb = new StringBuffer();
        for (Method method : methods) {
            // 得到方法返回值的 class type
            Class returnType = method.getReturnType();
            sb.append(returnType.getSimpleName() + " ");

            // 得到方法名称
            sb.append(method.getName() + "(");

            // 得到方法参数列表的 class type
            Class[] parameters = method.getParameterTypes();
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i].getSimpleName());
                if (i < parameters.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(");\n");
        }
        System.out.print(sb);
    }

    /**
     * 打印对象构造器的信息
     * java.lang.reflect.Constructor 类, 即构造器对象; 一个构造器就是一个 Constructor 对象.
     * Constructor 对象的获取方法:
     * 1. 通过 Class.getConstructor() 方法
     * 获取的是所有 public 构造器, 包括从父类继承的
     * <p>
     * 2. 通过 Class.getDeclaredConstructors() 方法
     * 获取的是所有该类自己声明的构造器, 无论任何访问修饰符
     *
     * @param obj
     */
    private static void printConstructorMessage(Object obj) {
        Class clazz = obj.getClass();
        System.out.println("该类的构造器信息:");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        StringBuffer sb = new StringBuffer();
        for (Constructor constructor : constructors) {
            // 得到构造器名称
            sb.append(constructor.getName() + "(");

            // 得到构造器参数列表的 class type
            Class[] parameters = constructor.getParameterTypes();
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i].getSimpleName());
                if (i < parameters.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append(");\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // printClassMessage(new String());
        // printFieldMessage(new String());
        // printMethodMessage(new String());
        printConstructorMessage(new String());

        printConstructorMessage(int.class);
    }
}


