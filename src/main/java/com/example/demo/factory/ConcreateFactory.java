package com.example.demo.factory;


/**
 * @author merlin
 * @create 2017-07-08 上午11:04
 */
public  class ConcreateFactory extends Factory{

  @Override
  public <T extends Shape> T createShape(Class<T> c) {
    T product = null;
    try {
      product = (T) Class.forName(c.getName()).newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return product;
  }
}
