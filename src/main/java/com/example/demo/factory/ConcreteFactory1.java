package com.example.demo.factory;

/**
 * 具体工厂
 * @author merlin
 * @create 2017-07-10 下午1:56
 */
public class ConcreteFactory1 implements AbstractFactory {

  //工厂方法一
  public AbstractProductA createProductA() {
    return new ConcreteProductA1();
  }

  //工厂方法二
  public AbstractProductB createProductB() {
    return new ConcreteProductB1();
  }

}
