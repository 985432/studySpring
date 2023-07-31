package com.wangleleStudy.抽象工厂.factory.impl;

import com.wangleleStudy.抽象工厂.entity.keybo.DellKeybo;
import com.wangleleStudy.抽象工厂.entity.keybo.Keybo;
import com.wangleleStudy.抽象工厂.entity.mouse.DellMouse;
import com.wangleleStudy.抽象工厂.entity.mouse.Mouse;
import com.wangleleStudy.抽象工厂.factory.PCFactory;

/**
 * {@link DellFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:41
 */
public class DellFactory implements PCFactory {

  public Mouse createMouse() {
    return new DellMouse();
  }

  @Override
  public Keybo createKeybo() {
    return new DellKeybo();
  }

}