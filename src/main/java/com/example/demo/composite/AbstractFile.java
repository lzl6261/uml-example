package com.example.demo.composite;

/**
 * 抽象文件类：抽象构件
 *
 * @author merlin
 * @create 2017-07-11 下午7:52
 */
public abstract class AbstractFile {

  public abstract void add(AbstractFile file);

  public abstract void remove(AbstractFile file);

  public abstract AbstractFile getChild(int i);

  public abstract void killVirus();

}
