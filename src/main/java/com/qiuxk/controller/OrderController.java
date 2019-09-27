package com.qiuxk.controller;


import com.qiuxk.annotation.ResponseResult;
import com.qiuxk.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author qiuxk
 * @Description: 测试controller返回结果的封装 需要自定义注解+拦截器
 * @create 2019/9/27
 **/


@RestController
@RequestMapping("/order")
@ResponseResult
public class OrderController {


    @RequestMapping("/tset")
    public Result order(){
        Result result  = new Result();
        return result;
    }
}
