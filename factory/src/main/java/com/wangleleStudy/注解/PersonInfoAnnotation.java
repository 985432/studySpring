package com.wangleleStudy.注解;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)  // 运行时注解 可以通过反射获取到
public @interface PersonInfoAnnotation {

  public String name();

  public int age() default 19;


  public int id() default -1;


  public String[] language() default {"java", "屁"};
}
