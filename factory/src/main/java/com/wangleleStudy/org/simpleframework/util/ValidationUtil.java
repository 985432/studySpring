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
   *
   * @param array 对象
   * @return 是否为空
   */
  public static boolean isEmpty(Collection<?> array) {
    return array == null || array.isEmpty();
  }

  /**
   * 判断对象是否为空
   *
   * @param array 对象
   * @return 是否为空
   */
  public static boolean isEmpty(Object[] array) {
    return array == null || array.length == 0;

  }

  /**
   * 判断对象是否为空
   *
   * @param obj 对象
   * @return 是否为空
   */
  public static boolean isEmpty(Object obj) {
    return obj == null;
  }

  /**
   * 判断对象是否不为空
   *
   * @param obj 对象
   * @return 是否不为空
   */
  public static boolean isNotEmpty(Object obj) {
    return obj != null;
  }

  /**
   * 判断对象是否不为空
   *
   * @param array 对象
   * @return 是否不为空
   */
  public static boolean isNotEmpty(Object[] array) {
    return array != null && array.length > 0;
  }

  /**
   * 判断对象是否不为空
   *
   * @param array 对象
   * @return 是否不为空
   */
  public static boolean isNotEmpty(Collection<?> array) {
    return array != null && !array.isEmpty();
  }


  /**
   * 判断字符串是否为空
   *
   * @param str 字符串
   * @return 是否为空
   */
  public static boolean isEmpty(String str) {
    return str == null || "".equals(str.trim());
  }


}