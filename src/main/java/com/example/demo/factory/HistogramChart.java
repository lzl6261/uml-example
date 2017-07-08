package com.example.demo.factory;

/**
 * @author merlin
 * @create 2017-07-07 上午11:08
 */
public class HistogramChart implements Chart {

  public HistogramChart() {
    System.out.println("创建柱状图！");
  }

  @Override
  public void display() {
    System.out.println("显示柱状图！");
  }
}
