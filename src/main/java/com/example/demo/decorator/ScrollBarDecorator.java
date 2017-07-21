package com.example.demo.decorator;

/**
 * 滚动条装饰类：具体装饰类
 *
 * @author merlin
 * @create 2017-07-12 下午8:16
 */
public class ScrollBarDecorator extends ComponentDecorator {

  public ScrollBarDecorator(Component1 component) {
    super(component);
  }

  public void display() {
    this.setScrollBar();
    super.display();
  }

  public void setScrollBar() {
    System.out.println("为构件增加滚动条！");
  }
}
