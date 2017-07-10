package com.example.demo.builder;

/**
 * 具体建造者
 *
 * @author merlin
 * @create 2017-07-10 下午6:00
 */
public class ConcreteBuilder extends Builder {


  @Override
  public void buildPartA() {
    product.setPartA("A");
  }

  @Override
  public void buildPartB() {

  }

  @Override
  public void buildPartC() {

  }
}
