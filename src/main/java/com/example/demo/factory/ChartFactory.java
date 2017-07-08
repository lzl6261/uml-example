package com.example.demo.factory;

/**
 * 图表工厂类
 *
 * @author merlin
 * @create 2017-07-07 上午11:10
 */
public class ChartFactory {

  //静态工厂方法
  public static Chart getChart(String type) {
    Chart chart = null;
    if (type.equalsIgnoreCase("histogram")) {
      chart = new HistogramChart();
      System.out.println("初始化设置柱状图！");
    } else if (type.equalsIgnoreCase("pie")) {
      chart = new PieChart();
      System.out.println("初始化设置饼状图！");
    } else if (type.equalsIgnoreCase("line")) {
      chart = new LineChart();
      System.out.println("初始化设置折线图！");
    }
    return chart;
  }

  public static void main(String args[]) {
    //String type = XMLUtil.getChartType(); //读取配置文件中的参数
    Chart chart = ChartFactory.getChart("histogram"); //通过静态工厂方法创建产品
    chart.display();
  }
}
