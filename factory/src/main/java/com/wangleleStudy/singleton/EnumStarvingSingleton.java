package com.wangleleStudy.singleton;

/**
 * {@link EnumStarvingSingleton}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 19:27
 */
public class EnumStarvingSingleton {
  private EnumStarvingSingleton(){}
  public static EnumStarvingSingleton getInstance(){
    return ContainerHolder.HOLDER.instance;
  }

  private enum ContainerHolder{
    HOLDER;
    private  EnumStarvingSingleton instance;
    ContainerHolder(){
      instance = new EnumStarvingSingleton();
    }
  }
}