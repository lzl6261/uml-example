package com.example.demo.factory;

/**
 * 具体产品
 *
 * @author merlin
 * @create 2017-07-10 下午2:00
 */
public class ConcreteProductA1 implements AbstractProductA {

  @Override
  public void display() {
    System.out.println("具体产品A1");
  }
}
