package com.wangleleStudy.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * {@link SingletonDome}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:12
 */
public class SingletonDome {


  public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    System.out.println(EnumStarvingSingleton.getInstance());
    System.out.println(EnumStarvingSingleton.getInstance());
    Class clazz = EnumStarvingSingleton.class;
    Constructor declaredConstructor = clazz.getDeclaredConstructor();
    declaredConstructor.setAccessible(true);
    EnumStarvingSingleton enumStarvingSingleton = (EnumStarvingSingleton)declaredConstructor.newInstance();
    EnumStarvingSingleton instance = enumStarvingSingleton.getInstance();
    System.out.println(instance);

  }

}