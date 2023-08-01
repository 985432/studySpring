package com.wangleleStudy.反射;

/**
 * {@link ConstructorController}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 9:09
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取构造函数
 * 1.获取所有的构造函数
 *    public Constructor<?>[] getConstructors() : 获取所有的public修饰的构造函数
 *    public Constructor<?>[] getDeclaredConstructors() : 获取所有的构造函数
 * 2.获取单个构造函数
 *   public Constructor<T> getConstructor(Class<?>... parameterTypes) : 获取单个public修饰的构造函数
 *   public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) : 获取单个构造函数
 *
 *   调用构造函数
 *   Constructor ->  public T newInstance(Object... initargs) : 调用构造函数创建对象
 */

public class ConstructorController {


  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    Class clazz = Class.forName("com.wangleleStudy.反射.Target");

    System.out.println("获取所有的共有构造函数");
    for (Constructor constructor : clazz.getConstructors()) {
      System.out.println(constructor);
    }

    System.out.println("获取所有的构造函数");
    for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
      System.out.println(declaredConstructor);
    }


    System.out.println("获取单个共有构造函数");
    Constructor constructor = clazz.getConstructor(String.class, int.class);
    System.out.println(constructor);

    System.out.println("获取单个构造函数");
    Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class);
    System.out.println(declaredConstructor);
    //暴力反射 忽略访问权限修饰符的安全检查
    declaredConstructor.setAccessible(true);
    //调用构造函数创建对象
    Object o = declaredConstructor.newInstance(1);
    System.out.println(o);
  }

}