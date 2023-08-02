package com.wangleleStudy.org.simpleframework.inject;

import com.wangleleStudy.org.simpleframework.inject.annotation.AutoWired;
import com.wangleleStudy.org.simpleframework.singleton.BeanContainer;
import com.wangleleStudy.org.simpleframework.util.ClassUtil;
import com.wangleleStudy.org.simpleframework.util.ValidationUtil;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;

/**
 * {@link DependencyInjector}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/2 18:38
 */
@Slf4j
public class DependencyInjector {

  private BeanContainer beanContainer;

  public DependencyInjector() {
    beanContainer = BeanContainer.getInstance();
  }


  /**
   * 执行IOC
   */
  public void doIoc() throws IllegalAccessException {
    if (!beanContainer.isLoaded()) {
      log.warn("BeanContainer has been loaded");
      return;
    }
    for (Class<?> clazz : beanContainer.getClasses()) {
      for (Field field : clazz.getDeclaredFields()) {
        if (field.isAnnotationPresent(AutoWired.class)) {
          AutoWired annotation = field.getAnnotation(AutoWired.class);
          String autoWiredValue = annotation.value();
          Class<?> fieldClass = field.getType();
          Object fieldValue = getFieldInstance(fieldClass, autoWiredValue);
          if (fieldValue == null) {
            throw new RuntimeException("unable to inject relevant type, target fieldClass is:" + fieldClass.getName() + "declaringClass is:" + fieldClass.getName());
          } else {
            Object targetBean = beanContainer.getBean(clazz);
            ClassUtil.setField(field, targetBean, fieldValue, true);
          }
        }
      }
    }
  }

  /**
   * 根据Class获取其实例或者实现类
   *
   * @param fieldClass     Class
   * @param autoWiredValue
   * @return 实例或者实现类
   */
  private Object getFieldInstance(Class<?> fieldClass, String autoWiredValue) {
    Set<Class<?>> classBySuper = beanContainer.getClassBySuper(fieldClass);
    if (!classBySuper.isEmpty()) {
      if (ValidationUtil.isEmpty(autoWiredValue)) {
        return Optional.ofNullable(classBySuper).orElseThrow(() -> new RuntimeException("multiple implemented classes for" + fieldClass.getName() + "please set @AutoWired's value to pick one")).iterator().next();
      } else {
        return beanContainer.getBean(classBySuper.stream().filter(clazz -> autoWiredValue.equals(clazz.getSimpleName())).findFirst().orElseThrow(() -> new RuntimeException("unable to find class:" + autoWiredValue)));
      }
    }
    return null;
  }


  /**
   * 获取接口的实现类
   *
   * @param fieldClass Class
   * @return 实现类
   */
  private Class<?> getImplementClass(Class<?> fieldClass) {
    Set<Class<?>> classSet = beanContainer.getClassBySuper(fieldClass);
    if (classSet.isEmpty()) return null;
    if (classSet.size() == 1) return classSet.iterator().next();
    throw new RuntimeException("multiple implemented classes for" + fieldClass.getName() + "please set @AutoWired's value to pick one");
  }

}