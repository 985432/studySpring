package com.wangleleStudy.抽象工厂.entity.mouse;

import lombok.Data;

/**
 * {@link HpMouse}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/7/27 19:43
 */
@Data
public class HpMouse implements Mouse {
  @Override
  public String sayHi() {
    return "我是惠普鼠标";
  }
}