package com.example.demo.decorator;

/**
 * 具体装饰类
 *
 * @author merlin
 * @create 2017-07-12 下午8:09
 */
public class ConcreteDecorator extends Decorator {

  public ConcreteDecorator(Component component) {
    super(component);
  }

  public void operation() {
    super.operation();  //调用原有业务方法
    addedBehavior();  //调用新增业务方法
  }

  //新增业务方法
  public void addedBehavior() {
  }
}
