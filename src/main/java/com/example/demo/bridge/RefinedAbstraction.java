package com.example.demo.bridge;

/**
 * 扩充抽象类
 *
 * @author merlin
 * @create 2017-07-11 下午6:59
 */
public class RefinedAbstraction extends Abstraction{

  @Override
  public void operation() {
    impl.operationImpl();

  }
}
