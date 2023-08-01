package com.wangleleStudy.工厂.工厂模式.entity;

import lombok.Data;

/**
 * {@link DellMouse}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:43
 */
@Data
public class DellMouse implements Mouse {
  @Override
  public String sayHi() {
    return "我是戴尔鼠标";
  }

}