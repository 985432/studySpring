package com.wangleleStudy.工厂.工厂模式.factory;

import com.wangleleStudy.工厂.工厂模式.entity.Mouse;

/**
 * {@link MouseFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:41
 */
public interface MouseFactory {

  public Mouse createMouse();

}