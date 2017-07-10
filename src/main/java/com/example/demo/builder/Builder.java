package com.example.demo.builder;

/**
 * 抽象建造者
 *
 * @author merlin
 * @create 2017-07-10 下午5:56
 */
public abstract class Builder {

  //创建产品对象
  protected Product product = new Product();

  public abstract void buildPartA();

  public abstract void buildPartB();

  public abstract void buildPartC();

  //返回产品对象
  public Product getResult() {
    return product;
  }
}
