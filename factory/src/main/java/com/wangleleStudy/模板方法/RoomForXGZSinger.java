package com.wangleleStudy.模板方法;

/**
 * {@link RoomForXGZSinger}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/7 16:56
 */
public class RoomForXGZSinger extends KTVRoom{
  @Override
  public void orderSong() {
    System.out.println("来首《起风了》");
  }
}