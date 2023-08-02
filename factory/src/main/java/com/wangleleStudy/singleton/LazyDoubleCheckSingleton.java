package com.wangleleStudy.singleton;

import lombok.Data;

/**
 * {@link LazyDoubleCheckSingleton}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:11
 */
@Data
public class LazyDoubleCheckSingleton {
  private static volatile LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

  private String name;

  private LazyDoubleCheckSingleton(){

  }

  public static LazyDoubleCheckSingleton getInstance(){
    if (lazyDoubleCheckSingleton == null){
      synchronized (LazyDoubleCheckSingleton.class){
        if (lazyDoubleCheckSingleton == null){
          lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
          //1.分配内存给这个对象
          //2.初始化对象
          //3.设置lazyDoubleCheckSingleton 指向刚分配的内存地址
        }
      }
    }
    return lazyDoubleCheckSingleton;
  }

}