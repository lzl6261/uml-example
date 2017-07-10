package com.example.demo.builder;

/**
 * 指挥者
 *
 * @author merlin
 * @create 2017-07-10 下午5:57
 */
public class Director {

  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public void setBuilder(Builder builder) {
    this.builder = builder;
  }

  //产品构建与组装方法
  public Product construct() {
    builder.buildPartA();
    builder.buildPartB();
    builder.buildPartC();
    return builder.getResult();
  }
}
