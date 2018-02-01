package edu.zzu.rbw.controller;

import edu.zzu.rbw.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHystrixFeignController {

    @Autowired
    SchedualServiceHi schedualServiceHi;


    @GetMapping("hi/{name}")
    public String hi(@PathVariable String name) {
        return schedualServiceHi.sayHiFromCLientOne(name);
    }

}
