package com.wangleleStudy.eventMode;

/**
 * {@link SingleClickEventListener}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/9 14:49
 */
public class SingleClickEventListener implements EventListener {
  @Override
  public void processEvent(Event event) {
    if ("singleClick".equals(event.getType())) {
      System.out.println("单击事件触发");
    }
  }
}