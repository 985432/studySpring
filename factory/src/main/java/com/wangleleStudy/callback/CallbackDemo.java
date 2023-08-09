package com.wangleleStudy.callback;

/**
 * {@link CallbackDemo}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/9 14:33
 */
public class CallbackDemo {


  //回调方法
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println("我要休息");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("我被回调了");
    });
    thread.start();
  }

}