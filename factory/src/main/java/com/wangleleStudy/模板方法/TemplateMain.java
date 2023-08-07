package com.wangleleStudy.模板方法;

/**
 * {@link TemplateMain}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/7 16:56
 */
public class TemplateMain {

  public static void main(String[] args) {
    RoomForCNSinger roomForCNSinger = new RoomForCNSinger();
    roomForCNSinger.procedure();
    System.out.println("==================================");
    RoomForXGZSinger roomForXGZSinger = new RoomForXGZSinger();
    roomForXGZSinger.procedure();
  }
}