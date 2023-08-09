package com.wangleleStudy.eventMode;

/**
 * {@link DoubleClickEventListener}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/9 14:51
 */
public class DoubleClickEventListener implements EventListener {
  @Override
  public void processEvent(Event event) {
    if ("doubleClick".equals(event.getType())) {
      System.out.println("双击事件触发");
    }
  }
}
