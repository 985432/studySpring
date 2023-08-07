package com.wangleleStudy.模板方法;

/**
 * {@link KTVRoom}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/7 16:51
 */
public abstract class KTVRoom {



  //模板方法
  public void procedure() {
    openDevice();
    orderSong();
    orderExtra();
    pay();
  }


  //模板自带方法，使用前必须打开设备
  public void openDevice() {
    System.out.println("打开视频和音响");
  }

  //子类必须实现的方法，必须点歌
  public abstract void orderSong();

  //钩子，额外开销视情况选择是否需要挂载
  protected void orderExtra() {
  }

  //模板自带方法，付款
  public void pay() {
    System.out.println("支付本次的消费账单。。。");
  }

}