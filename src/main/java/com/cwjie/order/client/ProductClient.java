package com.cwjie.order.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: eureka
 * @description:
 * @author: chenweijie
 * @create: 2019-03-01 20:09
 **/
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String getProductMsg();
}
