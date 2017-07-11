package com.example.demo.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 负载均衡器
 *
 * @author merlin
 * @create 2017-07-11 下午3:15
 */
public class LoadBalancer {

  private static LoadBalancer instance = null;

  //服务器集合
  private List serverList = null;

  private LoadBalancer() {
    serverList = new ArrayList();
  }

  //公有静态成员方法，返回唯一实例
  public static LoadBalancer getLoadBalancer() {
    if (instance == null) {
      instance = new LoadBalancer();
    }
    return instance;
  }

  //增加服务器
  public void addServer(String server) {
    serverList.add(server);
  }

  //删除服务器
  public void removeServer(String server) {
    serverList.remove(server);
  }

  //使用Random类随机获取服务器
  public String getServer() {
    Random random = new Random();
    int i = random.nextInt(serverList.size());
    return (String) serverList.get(i);
  }

}
