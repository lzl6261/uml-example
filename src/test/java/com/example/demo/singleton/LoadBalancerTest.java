package com.example.demo.singleton;

import com.example.demo.builder.Builder;
import com.example.demo.builder.ConcreteBuilder;
import com.example.demo.builder.Director;
import com.example.demo.builder.Product;
import org.junit.Test;

/**
 * 单例模式测试
 *
 * @author merlin
 * @create 2017-07-11 下午3:20
 */
public class LoadBalancerTest {

  @Test
  public void doTest() {
    LoadBalancer balancer = LoadBalancer.getLoadBalancer();

    //增加服务器
    balancer.addServer("Server 1");
    balancer.addServer("Server 2");
    balancer.addServer("Server 3");
    balancer.addServer("Server 4");
    //模拟客户端请求的分发
    for (int i = 0; i < 10; i++) {
      String server = balancer.getServer();
      System.out.println("分发请求至服务器： " + server);
    }

  }

}
