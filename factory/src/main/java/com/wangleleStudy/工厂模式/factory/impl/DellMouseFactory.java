package com.wangleleStudy.工厂模式.factory.impl;

import com.wangleleStudy.工厂模式.entity.DellMouse;
import com.wangleleStudy.工厂模式.entity.Mouse;
import com.wangleleStudy.工厂模式.factory.MouseFactory;

/**
 * {@link DellMouseFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:52
 */
public class DellMouseFactory implements MouseFactory {
  @Override
  public Mouse createMouse() {
    return new DellMouse();
  }
}