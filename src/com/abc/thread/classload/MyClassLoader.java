package com.abc.thread.classload;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 11:34
 */
public class MyClassLoader extends ClassLoader {
  // 定义默认的class 存放路径
  private final static Path DEFAULT_CLASS_DIR = Paths.get("G","classLoader1");
  private final Path classDir;
  public MyClassLoader(){
    super();
    this.classDir = DEFAULT_CLASS_DIR;
  }

  // 允许传入自定义路径
  public MyClassLoader(String classDir){
    super();
    this.classDir = Paths.get(classDir);
  }

  // 指定class 路径的同时 指定父类加载器
  public MyClassLoader(String classDir,ClassLoader parent){
    super(parent);
    this.classDir = Paths.get(classDir);
  }

  // 重写父类的findClass 方法 这是至关重要的步骤
  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    // 读取 class 的二进制数据
    byte[] classBytes = this.readClassBytes(name);
    // 如果没有数据 或者读取到的数据为空
    if(null == classBytes || classBytes.length == 0){
      throw new ClassNotFoundException("can't not find the class " + name);
    }
    // 调用defineClass 方法定义class
    return this.defineClass(name,classBytes,0,classBytes.length);
  }

  // 将class 文件读入内存
  private byte[] readClassBytes(String name) throws ClassNotFoundException {
    // 将包名分隔符转换为类名分隔符
    String classPath = name.replace(".","/");
    Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
    if(!classFullPath.toFile().exists()){
      throw new ClassNotFoundException("The class " + name + "not found.");
    }
    try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
      Files.copy(classFullPath,baos);
      return baos.toByteArray();
    }catch (IOException e){
      throw new ClassNotFoundException("load the class " + name + "occur error",e);
    }
  }

}
