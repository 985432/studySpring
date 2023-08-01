package com.wangleleStudy.工厂.简单工厂.factory;

import com.wangleleStudy.工厂.简单工厂.entity.DellMouse;
import com.wangleleStudy.工厂.简单工厂.entity.HpMouse;
import com.wangleleStudy.工厂.简单工厂.entity.Mouse;

/**
 * {@link MouseFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:41
 */
public class MouseFactory {
public static Mouse createMouse(String type) {
    if ("DELL".equals(type)) {
      return new DellMouse();
    } else if ("HP".equals(type)) {
      return new HpMouse();
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    Mouse mouse = MouseFactory.createMouse("DELL");
    System.out.println(mouse.sayHi());
  }
}