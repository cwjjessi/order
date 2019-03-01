package com.cwjie.order.controller;

import com.cwjie.order.client.ProductClient;
import com.cwjie.order.config.RestTemplateConfig;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: order
 * @description: 服务调用控制器
 * @author: chenweijie
 * @create: 2019-02-28 21:50
 **/
@RestController
public class ClientController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第一种方式
        /*RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8080/msg", String.class);*/

        // 第二种方式(利用LoadBalancerClient通过应用名获取url，然后再使用restTemplate)
        /*RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",instance.getHost(),instance.getPort() + "/msg");
        String forObject = restTemplate.getForObject(url, String.class);*/

        // 第三种方式(利用@LoadBalanced,可在restTempalte里使用应用名字)
//        String forObject = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        String forObject = productClient.getProductMsg();

        return forObject;

    }
}
