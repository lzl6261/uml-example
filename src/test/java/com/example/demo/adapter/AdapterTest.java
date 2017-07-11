package com.example.demo.adapter;

import org.junit.Test;

/**
 * 适配器模式
 *
 * @author merlin
 * @create 2017-07-11 下午4:59
 */
public class AdapterTest {

  @Test
  public void shapeTest() {
    ScoreOperation scoreOperation = new OperationAdapter();
    int scores[] = {84, 76, 50, 69, 90, 91, 88, 96};
    scoreOperation.sort(scores);
  }

}
