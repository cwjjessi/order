package com.cwjie.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: order
 * @description: 服务调用控制器
 * @author: chenweijie
 * @create: 2019-02-28 21:50
 **/
@RestController
public class ClientController {

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        return null;
    }
}
