package com.wangleleStudy.注解;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * {@link Annotation}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 19:36
 */
public class Annotation {


  public static void main(String[] args) throws Exception {


    System.out.println("获取类上的注解");
    Class<?> person = Class.forName("com.wangleleStudy.注解.Person");
    for (java.lang.annotation.Annotation annotation : person.getAnnotations()) {
      CourseInfoAnnotation annotation1 = (CourseInfoAnnotation) annotation;
          System.out.println("课程名  "+annotation1.courseName());
          System.out.println("课程标签  "+annotation1.courseTag());
          System.out.println("课程简介  "+annotation1.courseProfile());
          System.out.println("课程序号  "+annotation1.courseIndex());
    }

    System.out.println("获取方法上的注解");
    Method study = person.getMethod("study", String.class);
    Person person1 = (Person) person.newInstance();
    for (java.lang.annotation.Annotation annotation : study.getAnnotations()) {
      //判断注解是否存在
      if (study.isAnnotationPresent(CourseInfoAnnotation.class)){
        CourseInfoAnnotation annotation1 = (CourseInfoAnnotation) annotation;
        System.out.println("课程名  "+annotation1.courseName());
        System.out.println("课程标签  "+annotation1.courseTag());
        System.out.println("课程简介  "+annotation1.courseProfile());
        System.out.println("课程序号  "+annotation1.courseIndex());
        study.invoke(person1,annotation1.courseName());
      }
    }


    System.out.println("获取属性上的注解");
    Field name = person.getField("name");
    for (java.lang.annotation.Annotation annotation : name.getAnnotations()) {
      //判断注解是否存在
      if (name.isAnnotationPresent(PersonInfoAnnotation.class)){
        PersonInfoAnnotation annotation1 = (PersonInfoAnnotation) annotation;
        System.out.println("名字  "+annotation1.name());
        System.out.println("年龄  "+annotation1.age());
        System.out.println("语言  "+annotation1.language());
        name.set(person1,annotation1.name());
      }
    }
    System.out.println(person1.name);


  }
}