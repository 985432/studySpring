package com.wangleleStudy.org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link ClassUtil}
 *
 * <p>
 *
 * @author <a href="mailto:wanglele.wang@yunlsp.com">Wanglele.wang</a>
 * @version ${project.version}
 * @date 2023/8/1 9:11
 */
@Slf4j
public class ClassUtil {


  public static final String FILE_PROTOCOL = "file";

  /**
   * 获取包下类集合
   *
   * @param packageName 包名
   * @return 类集合
   */
  public static Set<Class<?>> extractPackageClass(String packageName) {
    //1.获取到类的加载器
    ClassLoader classLoader = getClassLoader();
    //2.通过类加载器获取到加载的资源信息
    URL resource = classLoader.getResource(packageName.replace(".", "/"));
    if (resource == null) {
      log.warn("unable to retrieve anything from package: " + packageName);
      return null;
    }
    //3.依据不同的资源类型，采用不同的方式获取资源的集合
    Set<Class<?>> classSet = null;
    //过滤出文件类型的资源
    if (resource.getProtocol().contains(FILE_PROTOCOL)) {
      classSet = new HashSet<>();
      File packageDirectory = new File(resource.getPath());
      extractClassFile(classSet, packageDirectory, packageName);
    }
    return classSet;
  }

  /**
   * 递归获取目标package里面的所有class文件（包括子package里的class文件）
   *
   * @param classSet         装载目标类的集合
   * @param packageDirectory 包目录
   * @param packageName     包名
   */
  private static void extractClassFile(Set<Class<?>> classSet, File packageDirectory, String packageName) {
    if (!packageDirectory.isDirectory()){
      return;
    }
    File[] files = packageDirectory.listFiles(new FileFilter() {
      @Override
      public boolean accept(File file) {
        if (file.isDirectory()) {
          return true;
        } else {
          //如果是文件，获取绝对值路径
          String absoluteFilePath = file.getAbsolutePath();
          if (absoluteFilePath.endsWith(".class")) {
            //若是class文件，直接加载
            try {
              addToClassSet(absoluteFilePath);
            } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
            }
          }
        }
        return false;
      }

      private void addToClassSet(String absoluteFilePath) throws ClassNotFoundException {
          //1.从class文件的绝对值路径里提取出包含了package的类名
          //如F:\obj\studySpring\factory\target\classes\com\wangleleStudy\org\simpleframework\core\annotation\entity\DellMouse.class
          //需要弄成com.imooc.entity.dto.MainPageInfoDTO
          absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
          String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
          className = className.substring(0, className.lastIndexOf("."));
          //2.通过反射机制获取对应的Class对象并加入到classSet里
          Class targetClass = loadClass(className);
          classSet.add(targetClass);
      }
    });
    if (files!=null){
      for (File file : files) {
        extractClassFile(classSet,file,packageName);
      }
    }

  }

  /**
   * 获取Class对象
   *
   * @param className class全名=package+类名
   * @return Class对象
   */
  private static Class<?> loadClass(String className) throws ClassNotFoundException {
    return  Class.forName(className);
  }

  public static  <T> T newInstance(Class<?> clazz,boolean accessible){
    try {
      Constructor declaredConstructor = clazz.getDeclaredConstructor();
      declaredConstructor.setAccessible(accessible);
      return (T) declaredConstructor.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }



  /**
   * 获取ClassLoader
   *
   * @return 当前ClassLoader
   */
  public static ClassLoader getClassLoader() {
    //java.lang.ClassLoader.getResource(String name)方法  获取当前类路径下的资源 返回值为URL
    return Thread.currentThread().getContextClassLoader();
  }


  public static void main(String[] args) {
    ClassUtil.extractPackageClass("com.wangleleStudy.org.simpleframework.util");
  }


}