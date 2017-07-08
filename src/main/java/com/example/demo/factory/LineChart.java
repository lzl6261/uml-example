package com.example.demo.factory;

/**
 * @author merlin
 * @create 2017-07-07 上午11:09
 */
public class LineChart implements Chart {

  public LineChart() {
    System.out.println("创建折线图！");
  }

  public void display() {
    System.out.println("显示折线图！");
  }
}
