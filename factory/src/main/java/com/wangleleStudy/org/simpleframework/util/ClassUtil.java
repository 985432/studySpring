package com.wangleleStudy.org.simpleframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
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
    return null;
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
            addToClassSet(absoluteFilePath);
          }
        }
        return false;
      }

      private void addToClassSet(String absoluteFilePath) {

      }
    });
    if (files!=null){
      for (File file : files) {
        extractClassFile(classSet,file,packageName);
      }
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