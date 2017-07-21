package com.example.demo.decorator;

/**
 * 抽象装饰类
 *
 * @author merlin
 * @create 2017-07-12 下午8:07
 */
public class Decorator implements Component {

  private Component component;  //维持一个对抽象构件对象的引用

  public Decorator(Component component)  //注入一个抽象构件类型的对象
  {
    this.component = component;
  }

  public void operation() {
    component.operation();  //调用原有业务方法
  }

}
