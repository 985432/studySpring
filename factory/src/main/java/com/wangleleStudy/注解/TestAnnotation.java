package com.wangleleStudy.注解;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 *
 * cd C:\Users\wanglele.wang\Desktop\wangleleStudy\src\main\java\com\wangleleStudy\注解
 *
 * javac TestAnnotation.java
 *
 * javap -verbose TestAnnotation
 *
 *
 * public interface com.wangleleStudy.娉ㄨВ.TestAnnotation extends java.lang.annotation.Annotation
 *
 *
 *
 *
 *
 *
 *
 *
 */



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface TestAnnotation {


}
