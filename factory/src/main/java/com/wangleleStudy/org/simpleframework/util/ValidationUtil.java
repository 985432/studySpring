package com.wangleleStudy.org.simpleframework.util;

import java.util.Collection;

/**
 * {@link ValidationUtil}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:55
 */
public class ValidationUtil {


  /**
   * 判断对象是否为空
   * @param array 对象
   * @return 是否为空
   */
  public static boolean isEmpty(Collection<?> array) {
    return array == null || array.isEmpty();
  }


}