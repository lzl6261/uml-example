package com.example.demo.factory;

/**
 * @author merlin
 * @create 2017-07-07 上午11:09
 */
public class PieChart implements Chart {

  public PieChart() {
    System.out.println("创建饼状图！");
  }

  public void display() {
    System.out.println("显示饼状图！");
  }
}
