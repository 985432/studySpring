package com.wangleleStudy.工厂.抽象工厂.entity.keybo;

/**
 * {@link DellKeybo}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 20:01
 */
public class DellKeybo implements Keybo{
  @Override
  public String sayHi() {
    return "我是戴尔键盘";
  }
}