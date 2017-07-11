package com.example.demo.bridge;

import org.junit.Test;

/**
 * 桥接模式测试
 *
 * @author merlin
 * @create 2017-07-11 下午7:22
 */
public class BridgeTest {


  @Test
  public void doTest() {
    Image image = new JPGImage();
    ImageImp imp = new WindowsImp();
    //可以通过配置文件读取
    // image = (Image)XMLUtil.getBean("image");
    //imp = (ImageImp)XMLUtil.getBean("os");
    image.setImageImp(imp);
    image.parseFile("北京");
  }


  @Test
  public void doTestCo() {
    Abstraction ab = new RefinedAbstraction();
    Implementor imp = new ConcreteImplementorA();
    //可以通过配置文件读取
    ab.setImpl(imp);
    ab.operation();
  }
}
