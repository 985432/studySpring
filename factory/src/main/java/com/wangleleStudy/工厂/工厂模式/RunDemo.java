package com.wangleleStudy.工厂.工厂模式;

import com.wangleleStudy.工厂.工厂模式.factory.MouseFactory;
import com.wangleleStudy.工厂.工厂模式.factory.impl.DellMouseFactory;

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
    MouseFactory mouseFactory = new DellMouseFactory();
    System.out.println(mouseFactory.createMouse().sayHi());
  }
}