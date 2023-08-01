package com.wangleleStudy.工厂.抽象工厂;

import com.wangleleStudy.工厂.抽象工厂.factory.impl.DellFactory;

/**
 * {@link RunDemo}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:54
 */
public class RunDemo {

  public static void main(String[] args) {
    DellFactory dellFactory = new DellFactory();
    System.out.println(dellFactory.createKeybo().sayHi());
    System.out.println(dellFactory.createMouse().sayHi());
  }
}