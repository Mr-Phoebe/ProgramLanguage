package com.mingrisoft;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringUtils {
    @SuppressWarnings("unchecked")
    public String toString(Object object) {
        Class clazz = object.getClass();							//获得代表该类的Class对象
        StringBuilder sb = new StringBuilder();					//利用StringBuilder来保存字符串
        Package packageName = clazz.getPackage();				//获得类所在的包
        sb.append("包名：" + packageName.getName() + "\t");		//输出类所在的包
        String className = clazz.getSimpleName();					//获得类的简单名称
        sb.append("类名：" + className + "\n");					//输出类的简单名称
        sb.append("公共构造方法：\n");
        //获得所有代表构造方法的Constructor数组
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());	//获得修饰符
            if (modifier.contains("public")) {						//查看修饰符是否含有“public”
                sb.append(constructor.toGenericString() + "\n");
            }
        }
        sb.append("公共域：\n");
        Field[] fields = clazz.getDeclaredFields();						//获得代表所有域的Field数组
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.contains("public")) {						//查看修饰符是否含有“public”
                sb.append(field.toGenericString() + "\n");
            }
        }
        sb.append("公共方法：\n");
        Method[] methods = clazz.getDeclaredMethods();				// 获得代表所有方法的Method[]数组
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.contains("public")) {						//查看修饰符是否含有“public”
                sb.append(method.toGenericString() + "\n");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new StringUtils().toString(new java.util.Date()));
    }
}
