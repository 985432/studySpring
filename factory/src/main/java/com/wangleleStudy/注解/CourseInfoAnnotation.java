package com.wangleleStudy.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)  // 运行时注解 可以通过反射获取到
public @interface CourseInfoAnnotation {


  public String courseName();

  public String courseTag();

  public String courseProfile();


  public int courseIndex() default 303;

}
