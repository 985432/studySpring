package com.wangleleStudy.org.simpleframework.inject;

import com.wangleleStudy.dome.controller.UserController;
import com.wangleleStudy.org.simpleframework.singleton.BeanContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependencyInjectorTest {


  @Test
  public void doIoc() throws IllegalAccessException {
    BeanContainer beanContainer = BeanContainer.getInstance();
    beanContainer.loadBeans("com.wangleleStudy.dome");
    Assertions.assertEquals(true,beanContainer.isLoaded());
    UserController userController = (UserController) beanContainer.getBean(UserController.class);
    Assertions.assertEquals(true,userController instanceof UserController);
    Assertions.assertEquals(null,userController.test());
    new DependencyInjector().doIoc();
    Assertions.assertNotEquals(null,userController.test());
  }




}