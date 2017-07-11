package com.example.demo.composite;

/**
 * 图像文件类：叶子构件
 *
 * @author merlin
 * @create 2017-07-11 下午7:52
 */
public class ImageFile extends AbstractFile {

  private String name; 

  public ImageFile(String name) {
    this.name = name;
  }

  @Override
  public void add(AbstractFile file) {

  }

  @Override
  public void remove(AbstractFile file) {

  }

  @Override
  public AbstractFile getChild(int i) {
    return null;
  }

  @Override
  public void killVirus() {
    System.out.println("----对图像文件'" + name + "'进行扫描");
  }
}
