package com.wangleleStudy.模板方法;

/**
 * {@link RoomForCNSinger}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/7 16:54
 */
public class RoomForCNSinger extends KTVRoom{
  @Override
  public void orderSong() {
    System.out.println("来首《东风破》");
  }

  @Override
  protected void orderExtra() {
    System.out.println("东西真便宜，一样来一个");
  }
}