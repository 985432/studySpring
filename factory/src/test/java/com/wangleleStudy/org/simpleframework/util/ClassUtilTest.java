package com.wangleleStudy.org.simpleframework.util;

import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * {@link ClassUtilTest}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 18:53
 */
public class ClassUtilTest {



  @Test
  public void extractPackageClassTest() {
    Set<Class<?>> classSet = ClassUtil.extractPackageClass("com.wangleleStudy.org.simpleframework.util");
    classSet.forEach(System.out::println);
  }


}