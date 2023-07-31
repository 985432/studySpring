package com.wangleleStudy.工厂模式.factory.impl;

import com.wangleleStudy.工厂模式.entity.HpMouse;
import com.wangleleStudy.工厂模式.entity.Mouse;
import com.wangleleStudy.工厂模式.factory.MouseFactory;

/**
 * {@link HPMouseFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:53
 */
public class HPMouseFactory implements MouseFactory {
  @Override
  public Mouse createMouse() {
    return new HpMouse();
  }
}