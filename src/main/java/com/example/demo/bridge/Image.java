package com.example.demo.bridge;

/**
 * 抽象图像类：抽象类
 *
 * @author merlin
 * @create 2017-07-11 下午7:15
 */
public abstract class Image {

  protected ImageImp imp;

  public void setImageImp(ImageImp imp) {
    this.imp = imp;
  }

  public abstract void parseFile(String fileName);
}
