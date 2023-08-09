package com.wangleleStudy.eventMode;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link EventSource}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/9 14:51
 */
public class EventSource {

  private List<EventListener> listeners = new ArrayList<>();

  public void register(EventListener eventListener) {
    listeners.add(eventListener);
  }

  public void publishEvent(Event event) {
    for (EventListener listener : listeners) {
      listener.processEvent(event);
    }
  }

}