package com.example.demo.factory;

import com.example.demo.builder.Builder;
import com.example.demo.builder.ConcreteBuilder;
import com.example.demo.builder.Director;
import com.example.demo.builder.Product;
import org.junit.Test;

/**
 * 创造者模式测试
 *
 * @author merlin
 * @create 2017-07-10 下午6:03
 */
public class BuilderTest {

  @Test
  public void doTest() {
    Builder builder = new ConcreteBuilder(); //可通过配置文件实现
    Director director = new Director(builder);
    Product product = director.construct();
  }
}