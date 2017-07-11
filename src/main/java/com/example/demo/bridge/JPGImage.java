package com.example.demo.bridge;

/**
 * JPG格式图像：扩充抽象类
 *
 * @author merlin
 * @create 2017-07-11 下午7:19
 */
public class JPGImage extends Image {

  @Override
  public void parseFile(String fileName) {
    Matrix m = new Matrix();
    imp.doPaint(m);
    System.out.println(fileName + "，格式为JPG。");
  }
}
