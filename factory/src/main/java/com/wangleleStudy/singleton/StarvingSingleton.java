package com.wangleleStudy.singleton;

/**
 * {@link StarvingSingleton}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:10
 */
public class StarvingSingleton {

  private static  final  StarvingSingleton starvingSingleton = new StarvingSingleton();

  private StarvingSingleton(){

  }
  public static StarvingSingleton getInstance(){
    return starvingSingleton;
  }


}