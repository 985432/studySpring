package com.wangleleStudy.eventMode;

/**
 * {@link EventMain}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/9 14:56
 */
public class EventMain {

  public static void main(String[] args) {
    EventSource eventSource = new EventSource();
    SingleClickEventListener singleClickEventListener = new SingleClickEventListener();
    DoubleClickEventListener doubleClickEventListener = new DoubleClickEventListener();

    Event event = new Event();
    event.setType("doubleClick");
    eventSource.publishEvent(event);
    eventSource.register(singleClickEventListener);
    eventSource.register(doubleClickEventListener);
    eventSource.publishEvent(event);
  }

}