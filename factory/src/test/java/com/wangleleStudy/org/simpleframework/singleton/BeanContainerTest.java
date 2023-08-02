package com.wangleleStudy.org.simpleframework.singleton;

import com.wangleleStudy.dome.assignable.FirstClass;
import com.wangleleStudy.dome.assignable.FirstInterface;
import com.wangleleStudy.dome.controller.UserController;
import com.wangleleStudy.dome.service.UserService;
import com.wangleleStudy.dome.service.impl.UserServiceImpl;
import com.wangleleStudy.org.simpleframework.core.annotation.Controller;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BeanContainerTest {

  private static BeanContainer beanContainer;

  @BeforeAll
  static void init(){
    beanContainer=  BeanContainer.getInstance();
  }

  @Order(1)
  @Test
  public void loadBeans() {

    Assertions.assertEquals(false,BeanContainer.getInstance().isLoaded());
    beanContainer.loadBeans("com.wangleleStudy.dome");
    Assertions.assertEquals(4,beanContainer.size());

  }

  @Order(2)
  @Test
  public void getBean() {
    UserController userController = (UserController) beanContainer.getBean(UserController.class);
    Assertions.assertEquals(true,userController instanceof UserController);
    userController.test();
  }

  @Order(3)
  @Test
  public void getClassesByAnnotation() {
    Assertions.assertEquals(true,beanContainer.isLoaded());
    Assertions.assertEquals(2,beanContainer.getClassesByAnnotation(Controller.class).size());
  }

  @Order(4)
  @Test
  public void getClassesBySuper() {
    Assertions.assertEquals(true,beanContainer.isLoaded());
    Assertions.assertEquals(true,beanContainer.getClassBySuper(UserService.class).contains(UserServiceImpl.class));
  }


}