package com.wangleleStudy.注解;

/**
 * {@link Person}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 19:32
 */
@CourseInfoAnnotation(courseName = "java", courseTag = "编程语言", courseProfile = "这是一个java课程")
public class Person {

  @PersonInfoAnnotation(name = "wanglele", language = {"java", "c++"})
  public String name;

  @CourseInfoAnnotation(courseName = "python", courseTag = "编程语言", courseProfile = "这是一个python课程",courseIndex = 144)
  public void study( String language) {
    System.out.println("我正在学习" + language);
  }




}