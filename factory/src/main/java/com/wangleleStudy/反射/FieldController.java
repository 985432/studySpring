package com.wangleleStudy.反射;

/**
 * {@link FieldController}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 9:22
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 *获取对象的属性
 * 1.批量的
 *   1).Field[] getFields():获取所有的"公有字段   包括：父类的"
 *   2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；  不包含： 父类的；
 * 2.获取单个的：
 *  1).public Field getField(String fieldName):获取某个"公有的"字段；  包括：父类的
 *  2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)  不包括：父类的；
 *  设置字段的值：
 *  Field --> public void set(Object obj,Object value):
 *                参数说明：
 *                1.obj:要设置的字段所在的对象；
 *                2.value:要为字段设置的值；
 *                Field --> public Object get(Object obj):获取指定对象中此字段的值
 */
public class FieldController {


  public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

    Class<?> clazz = Class.forName("com.wangleleStudy.反射.Target");
    System.out.println("获取所有的公有字段");
    for (Field field : clazz.getFields()) {
      System.out.println(field);
    }

    System.out.println("获取所有的字段");
    for (Field declaredField : clazz.getDeclaredFields()) {
      System.out.println(declaredField);
    }

    System.out.println("获取单个公有字段");
    Field field = clazz.getField("name");
    Target target = (Target) clazz.getConstructor().newInstance();
    field.set(target,"wanglele name");
    System.out.println("获取单个字段的值  "+target.name);

    System.out.println("获取单个私有字段");
    Field declaredField = clazz.getDeclaredField("targetInfo");
    System.out.println(declaredField);
    //暴力反射 忽略访问权限修饰符的安全检查
    declaredField.setAccessible(true);
    declaredField.set(target,"wanglele targetInfo");
    System.out.println("打印私有的"+target);

    System.out.println("获取单个公有字段  父类");
    Field field1 = clazz.getField("publicName");
    System.out.println(field1);

    System.out.println("获取单个私有字段  父类");
    Field declaredField1 = clazz.getDeclaredField("privateName");
    System.out.println(declaredField1);

  }


}