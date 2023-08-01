package com.wangleleStudy.反射;

/**
 * {@link MethodController}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 18:55
 */

import java.lang.reflect.Method;

/**
 * 1. 获取所有的方法
 *   getMethods() 获取所有的public方法，包括父类继承的方法
 *   getDeclaredMethods() 获取所有的方法，包括私有的，不包括父类继承的方法
 * 2. 获取指定的方法
 *  getMethod(String name, Class<?>... parameterTypes) 获取指定的public方法，包括父类继承的方法
 *  getDeclaredMethod(String name, Class<?>... parameterTypes) 获取指定的方法，包括私有的，不包括父类继承的方法
 *      name: 方法名
 *      parameterTypes: 形参类型
 *      通过方法名和形参类型可以唯一确定一个方法
 * 3. 执行方法
 *    Object invoke(Object obj, Object... args)
 *        obj: 要执行的对象
 *        args: 执行方法时传递的实参
 *        返回值: 方法的返回值
 */
public class MethodController {


  public static void main(String[] args) throws Exception {


    System.out.println("获取所有的方法");
    Class<?> clazz = Class.forName("com.wangleleStudy.反射.Target");

    System.out.println("获取所有的public方法，包括父类继承的方法");
    for (java.lang.reflect.Method method : clazz.getMethods()) {
      System.out.println(method);
    }

    System.out.println("获取所有的方法，包括私有的，不包括父类继承的方法");
    for (Method declaredMethod : clazz.getDeclaredMethods()) {
      System.out.println(declaredMethod);
    }

    System.out.println("获取指定的public方法，包括父类继承的方法");
    Method show1 = clazz.getMethod("show1", String.class);
    show1.invoke(clazz.newInstance(),"反射运行show1");

    System.out.println("获取指定的方法，包括私有的，不包括父类继承的方法");
    Method show4 = clazz.getDeclaredMethod("show4", int.class);
    //暴力反射 忽略访问权限修饰符的安全检查
//    show4.setAccessible(true);
    show4.invoke(clazz.newInstance(),1);


  }

}