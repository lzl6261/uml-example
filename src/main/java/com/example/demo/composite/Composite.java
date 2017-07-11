package com.example.demo.composite;

import java.util.ArrayList;

/**
 * 容器构件
 *
 * @author merlin
 * @create 2017-07-11 下午7:47
 */
public class Composite extends Component {

  private ArrayList<Component> list = new ArrayList<Component>();

  @Override
  public void add(Component c) {
    list.add(c);

  }

  @Override
  public void remove(Component c) {
    list.remove(c);

  }

  @Override
  public Component getChild(int i) {
    return (Component) list.get(i);
  }

  @Override
  public void operation() {
    //容器构件具体业务方法的实现
    //递归调用成员构件的业务方法
    for (Object obj : list) {
      ((Component) obj).operation();
    }

  }
}
