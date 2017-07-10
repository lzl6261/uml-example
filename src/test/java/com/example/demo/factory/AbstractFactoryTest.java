package com.example.demo.factory;

import org.junit.Test;

/**
 * 抽象工厂测试
 *
 * @author merlin
 * @create 2017-07-10 下午2:04
 */
public class AbstractFactoryTest {

  @Test
  public void aFactoryTest() {
    AbstractFactory factory = (AbstractFactory) XMLUtil.getBean();
    AbstractProductA abstractProductA = factory.createProductA();
    AbstractProductB abstractProductB = factory.createProductB();
    abstractProductA.display();
    abstractProductB.display();

  }
}
