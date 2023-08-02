package com.wangleleStudy.dome.service.impl;

import com.wangleleStudy.dome.service.UserService;
import com.wangleleStudy.org.simpleframework.core.annotation.Service;

/**
 * {@link UserServiceImpl}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/2 9:21
 */
@Service
public class UserServiceImpl implements UserService {
  @Override
  public void test() {
    System.out.println("user");
  }
}