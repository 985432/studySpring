package com.wangleleStudy.抽象工厂.factory.impl;

import com.wangleleStudy.抽象工厂.entity.keybo.HpKeybo;
import com.wangleleStudy.抽象工厂.entity.keybo.Keybo;
import com.wangleleStudy.抽象工厂.entity.mouse.HpMouse;
import com.wangleleStudy.抽象工厂.entity.mouse.Mouse;
import com.wangleleStudy.抽象工厂.factory.PCFactory;

/**
 * {@link HpFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:59
 */
public class HpFactory implements PCFactory {


  public Keybo createKeybo() {
    return new  HpKeybo();
  }

  public Mouse createMouse() {
    return new HpMouse();
  }


}