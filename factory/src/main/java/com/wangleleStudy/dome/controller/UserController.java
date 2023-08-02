package com.wangleleStudy.dome.controller;

import com.wangleleStudy.dome.service.UserService;
import com.wangleleStudy.org.simpleframework.core.annotation.Controller;
import com.wangleleStudy.org.simpleframework.inject.annotation.AutoWired;

/**
 * {@link UserController}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 20:04
 */
@Controller
public class UserController {

  @AutoWired(value = "UserServiceImpl1") private UserService userService;


  public UserService test(){
    return userService;
  }

}