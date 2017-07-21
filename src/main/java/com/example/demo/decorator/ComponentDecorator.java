package com.example.demo.decorator;

/**
 * 构件装饰类：抽象装饰类
 *
 * @author merlin
 * @create 2017-07-12 下午8:15
 */
public class ComponentDecorator extends Component1 {

  private Component1 component;  //维持对抽象构件类型对象的引用

  public ComponentDecorator(Component1 component)  //注入抽象构件类型的对象
  {
    this.component = component;
  }


  @Override
  public void display() {
    component.display();
  }
}
