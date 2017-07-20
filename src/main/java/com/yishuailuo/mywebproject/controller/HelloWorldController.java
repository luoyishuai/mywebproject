package com.yishuailuo.mywebproject.controller;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.form.HelloWorldForm;
import com.yishuailuo.mywebproject.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luoyishuai on 17/6/4.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String returnWelcome() {
        return helloWorldService.returnWelcome();
    }

    @GetMapping("/{name}/desc")
    public String getDesc(@PathVariable(value = "name") String name) {
        return helloWorldService.getHelloWorldDesc(name);
    }

    @PostMapping("/hello-world")
    public HelloWorld addHelloWorld(HelloWorldForm helloWorldForm){
        HelloWorld helloWorld = HelloWorld.builder()
                .name(helloWorldForm.getName())
                .nameDesc(helloWorldForm.getNameDesc())
                .build();
        return helloWorldService.add(helloWorld);
    }
}
