package com.example.demo;

import com.example.demo.composite.AbstractFile;
import com.example.demo.composite.Component;
import com.example.demo.composite.Composite;
import com.example.demo.composite.Folder;
import com.example.demo.composite.ImageFile;
import com.example.demo.composite.Leaf;
import com.example.demo.composite.TextFile;
import org.junit.Test;

/**
 * 组合模式测试
 *
 * @author merlin
 * @create 2017-07-11 下午7:57
 */
public class CompositeTest {


  @Test
  public void doBase() {
    Component composite, leaf;

    leaf = new Leaf();
    composite = new Composite();
    composite.add(leaf);

    composite.operation();

  }


  @Test
  public void doTest() {
    AbstractFile file1, file2, file3, file4, file5, folder1, folder2, folder3, folder4;

    folder1 = new Folder("Sunny的资料");
    folder2 = new Folder("图像文件");
    folder3 = new Folder("文本文件");
    folder4 = new Folder("视频文件");

    file1 = new ImageFile("小龙女.jpg");
    file2 = new ImageFile("张无忌.gif");
    file3 = new TextFile("九阴真经.txt");
    file4 = new TextFile("葵花宝典.doc");

    folder2.add(file1);
    folder2.add(file2);
    folder3.add(file3);
    folder3.add(file4);
    folder1.add(folder2);
    folder1.add(folder3);
    folder1.add(folder4);

    //从“Sunny的资料”节点开始进行扫描操作
    folder1.killVirus();

  }

}
