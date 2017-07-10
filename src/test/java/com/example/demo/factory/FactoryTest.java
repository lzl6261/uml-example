package com.example.demo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import org.junit.Test;

/**
 * 简单工厂模式测试
 *
 * @author merlin
 * @create 2017-07-08 上午10:52
 */
public class FactoryTest {


  @Test
  public void shapeTest() {
    Factory factory = new ConcreateFactory();
    Round round = factory.createShape(Round.class);
    Square square=factory.createShape(Square.class);
    square.draw();
    round.draw();
  }
}
