package com.wangleleStudy.模板方法;

/**
 * {@link AbstractTemplate}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/7 16:47
 */
public abstract class AbstractTemplate {

  //模板方法
  public void templateMethod() {
    //调用基本方法
    abstractMethod();
    hookMethod();
    concreteMethod();
  }

  //具体方法
  public void concreteMethod() {
    System.out.println("模板里自带的实现方法，万年不变");
  }

  //钩子方法
  protected void hookMethod() {
  }

  //抽象方法
  public abstract void  abstractMethod() ;



}