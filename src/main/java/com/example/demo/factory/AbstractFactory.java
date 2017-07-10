package com.example.demo.factory;

/**
 * 抽象工厂
 *
 * @author merlin
 * @create 2017-07-10 下午1:52
 */
public interface AbstractFactory {

  public AbstractProductA createProductA();

  public AbstractProductB createProductB();

}
