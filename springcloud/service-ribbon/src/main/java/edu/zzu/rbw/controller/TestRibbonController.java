package edu.zzu.rbw.controller;

import edu.zzu.rbw.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRibbonController {

    @Autowired
    private HelloService helloService;


    @GetMapping("hi/{name}")
    public String hi(@PathVariable String name) {
        return helloService.hiService(name);
    }

}
