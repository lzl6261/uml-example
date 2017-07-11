package com.example.demo.bridge;

/**
 * Linux操作系统实现类：具体实现类
 *
 * @author merlin
 * @create 2017-07-11 下午7:18
 */
public class LinuxImp implements ImageImp {

  @Override
  public void doPaint(Matrix m) {
    System.out.print("在Linux操作系统中显示图像：");
  }
}
