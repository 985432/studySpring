package com.wangleleStudy.org.simpleframework.singleton;

import com.wangleleStudy.org.simpleframework.core.annotation.Component;
import com.wangleleStudy.org.simpleframework.core.annotation.Controller;
import com.wangleleStudy.org.simpleframework.core.annotation.Repository;
import com.wangleleStudy.org.simpleframework.core.annotation.Service;
import com.wangleleStudy.org.simpleframework.util.ClassUtil;
import com.wangleleStudy.org.simpleframework.util.ValidationUtil;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link BeanContainer}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:43
 */
@NoArgsConstructor
@Slf4j
public class BeanContainer {


  /**
   * 存放所有被配置标记的目标对象的Map
   */
  private static final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

  /**
   * 加载bean的注解列表
   */
  public static final List<Class<? extends Annotation>> BEAN_ANNOTATION = Arrays.asList(Component.class, Controller.class, Service.class, Repository.class);


  /**
   * 容器是否已经加载过bean
   */
  private boolean loaded = false;

  /**
   * 是否已经加载过bean
   *
   * @return 是否已经加载过bean
   */
  public boolean isLoaded() {
    return loaded;
  }


  /**
   * 扫描加载所有bean
   *
   * @param packageName 包名
   */
  public int size() {
    return beanMap.size();
  }

  public static BeanContainer getInstance() {
    return ContainerHolder.HOLDER.instance;
  }

  private enum ContainerHolder {
    HOLDER;
    private BeanContainer instance;

    ContainerHolder() {
      instance = new BeanContainer();
    }
  }

  /**
   * 扫面加载所有Bean
   *
   * @param packageName
   */
  public void loadBeans(String packageName) {
    if (isLoaded()) {
      log.warn("BeanContainer has been loaded");
      return;
    }
    Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
    if (ValidationUtil.isEmpty(classSet)) {
      log.warn("extract nothing from packageName: " + packageName);
      return;
    }
    for (Class<?> clazz : classSet) {
      for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
        //如果类上面标记了定义的注解
        if (clazz.isAnnotationPresent(annotation)) {
          //将目标类本身作为键，目标类的实例作为值，放入到beanMap中
          beanMap.put(clazz, ClassUtil.newInstance(clazz, true));
        }
      }
    }
    loaded = true;
  }

  /**
   * 添加一个class对象及其bean实例
   *
   * @param clazz class对象
   * @param bean  bean实例
   * @return 原有的bean实例，没有则返回null
   */
  public Object addBean(Class<?> clazz, Object bean) {
    return beanMap.put(clazz, bean);
  }

  /**
   * 移除一个IOC容器管理的对象
   *
   * @param clazz class对象
   * @return 删除的bean实例，没有则返回null
   */
  public Object removeBean(Class<?> clazz) {
    return beanMap.remove(clazz);
  }

  /**
   * 根据class对象获取bean实例
   *
   * @param clazz class对象
   * @return bean实例
   */
  public Object getBean(Class<?> clazz) {
    return beanMap.get(clazz);
  }

  /**
   * 获取容器管理的所有class对象集合
   *
   * @return class对象集合
   */

  public Set<Class<?>> getClasses() {
    return beanMap.keySet();
  }

  /**
   * 获取所有bean集合
   *
   * @return bean集合
   */
  public Set<Object> getBeans() {
    return new HashSet<>(beanMap.values());
  }

  /**
   * 根据注解筛选出bean的class集合
   *
   * @param annotation 注解
   * @return class集合
   */
  public Set<Class<?>> getClassesByAnnotation(Class<? extends Annotation> annotation) {
    //1.获取beanMap的所有class对象
    Set<Class<?>> keySet = getClasses();
    if (ValidationUtil.isEmpty(keySet)) {
      log.warn("nothing in beanMap");
      return null;
    }
    //2.通过注解筛选被注解标记的class对象，并添加到classSet里
    Set<Class<?>> classSet = new HashSet<>();
    for (Class<?> clazz : keySet) {
      //类是否有相关注解标记
      if (clazz.isAnnotationPresent(annotation)) {
        classSet.add(clazz);
      }
    }
    return classSet.size() > 0 ? classSet : null;
  }

  /**
   * 通过接口或者父类获取实现类或者子类的class集合，不包括其本身
   *
   * @param interfaceOrClass 接口class或者父类class
   * @return 实现类class集合或者子类class集合
   */
  public Set<Class<?>> getClassBySuper(Class<?> interfaceOrClass) {
    //1.获取beanMap的所有class对象
    Set<Class<?>> keySet = getClasses();
    if (ValidationUtil.isEmpty(keySet)) {
      log.warn("nothing in beanMap");
      return null;
    }
    //2.通过注解筛选被注解标记的class对象，并添加到classSet里
    Set<Class<?>> classSet = new HashSet<>();
    for (Class<?> clazz : keySet) {
      //类是否有相关注解标记
      if (interfaceOrClass.isAssignableFrom(clazz) && !clazz.equals(interfaceOrClass)) {
        classSet.add(clazz);
      }
    }
    return classSet.size() > 0 ? classSet : null;
  }

}