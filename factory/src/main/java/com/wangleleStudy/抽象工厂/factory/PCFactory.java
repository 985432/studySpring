package com.wangleleStudy.抽象工厂.factory;

import com.wangleleStudy.抽象工厂.entity.keybo.Keybo;
import com.wangleleStudy.抽象工厂.entity.mouse.Mouse;

/**
 * {@link PCFactory}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 20:03
 */
public interface PCFactory {

  public Mouse createMouse();

  public Keybo createKeybo();

}