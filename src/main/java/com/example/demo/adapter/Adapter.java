package com.example.demo.adapter;

/**
 * 适配器类
 *
 * @author merlin
 * @create 2017-07-11 下午4:50
 */
public class Adapter extends Target {

  private Adaptee adaptee; //维持一个对适配者对象的引用

  public Adapter(Adaptee adaptee) {
    this.adaptee = adaptee;
  }


  @Override
  public void request() {
    adaptee.specificRequest();//转发调用
  }
}
