package com.wangleleStudy.反射;

/**
 * {@link Target}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/31 9:01
 */
public class Target extends TargetOrigin {
  //构造函数
  public Target(String str) {
    System.out.println("（默认）执行构造函数  "+str);
  }

  public Target() {
    System.out.println("执行公有无参构造函数");
  }

  //有一个参数的构造函数
  public Target(char name) {
    System.out.println("执行有一个参数的构造函数，参数值为"+name);
  }

  //有多个参数的构造函数
  public Target(String name ,int index) {
    System.out.println("执行有多个参数的构造函数，参数值为【目标名】："+name+"【序号】："+index);
  }

  //受保护的构造函数
  protected Target(boolean n) {
    System.out.println("受保护的构造函数 n="+n);
  }

  //私有构造函数
  private Target(int index) {
    System.out.println("私有的构造函数   序号："+index);
  }


  //**************字段***************//

  public String name;
  protected int index;
  char type;
  private String targetInfo;


  //**************成员方法***************//

  public void show1(String s){
    System.out.println("调用了：公有的，String参数的show1(): s = " + s);
  }

  protected void show2(){
    System.out.println("调用了：受保护的，无参的show2()");
  }

  void show3(){
    System.out.println("调用了：默认的，无参的show3()");
  }

  private String show4(int index){
    System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): index = " + index);
    return "show4result";
  }


  @Override
  public String toString() {
    return "Target{" +
        "name='" + name + '\'' +
        ", index=" + index +
        ", type=" + type +
        ", targetInfo='" + targetInfo + '\'' +
        '}';
  }


  /**
   * 通过反射获取对象的三种方式
   * 1.通过Class.forName("全类名")获取
   * 2.通过类名.class获取
   * 3.通过对象.getClass()获取
   */
  public static void main(String[] args) {
    //第一种获取
    Target target = new Target();
    Class class1 = target.getClass();
    System.out.println("1st   " + class1.getName());
    //第二种获取
    Class class2 = Target.class;
    System.out.println("2nd   " + class2.getName());
    System.out.println(class1 == class2);
    //第三种获取
    try {
      Class class3 = Class.forName("com.wangleleStudy.反射.Target");
      System.out.println("3rd   " + class3.getName());
      System.out.println(class2 == class3);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

  }


}