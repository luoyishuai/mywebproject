package com.yishuailuo.mywebproject.controller;

import com.yishuailuo.mywebproject.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luoyishuai on 17/6/4.
 */
@Controller
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    @ResponseBody
    public String returWelcome() {
        return helloWorldService.returnWelcome();
    }
}
