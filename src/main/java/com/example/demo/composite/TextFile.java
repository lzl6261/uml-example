package com.example.demo.composite;

/**
 * 文本文件类：叶子构件
 *
 * @author merlin
 * @create 2017-07-11 下午7:52
 */
public class TextFile extends AbstractFile {

  private String name;

  public TextFile(String name) {
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
    System.out.println("----对文本文件'" + name + "'进行扫描");
  }
}
