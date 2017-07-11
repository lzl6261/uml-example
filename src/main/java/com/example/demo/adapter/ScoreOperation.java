package com.example.demo.adapter;

/**
 * 抽象成绩操作类：目标接口
 *
 * @author merlin
 * @create 2017-07-11 下午4:54
 */
public interface ScoreOperation {

  public int[] sort(int array[]); //成绩排序

  public int search(int array[], int key); //成绩查找

}
