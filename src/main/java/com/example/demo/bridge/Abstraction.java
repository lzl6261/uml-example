package com.example.demo.bridge;

/**
 * 抽象类
 *
 * @author merlin
 * @create 2017-07-11 下午6:58
 */
public abstract class Abstraction {

  protected Implementor impl; //定义实现类接口对象

  public void setImpl(Implementor impl) {
    this.impl=impl;
  }

  public abstract void operation();



}
