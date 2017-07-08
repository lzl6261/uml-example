package com.example.demo.factory;

/**
 * 工厂接口
 *
 * @author merlin
 * @create 2017-07-08 上午11:28
 */
public abstract class Factory {

  public abstract  <T extends Shape> T createShape(Class<T> c);
}
