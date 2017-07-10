package com.example.demo.builder;

/**
 * 产品角色
 *
 * @author merlin
 * @create 2017-07-10 下午5:52
 */
public class Product {

  //定义部件，部件可以是任意类型，包括值类型和引用类型
  private String partA;
  private String partB;
  private String partC;

  public String getPartA() {
    return partA;
  }

  public void setPartA(String partA) {
    this.partA = partA;
  }

  public String getPartB() {
    return partB;
  }

  public void setPartB(String partB) {
    this.partB = partB;
  }

  public String getPartC() {
    return partC;
  }

  public void setPartC(String partC) {
    this.partC = partC;
  }
}
