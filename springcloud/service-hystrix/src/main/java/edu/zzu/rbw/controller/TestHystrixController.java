package edu.zzu.rbw.controller;

import edu.zzu.rbw.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHystrixController {

    @Autowired
    HiService hiService;


    @GetMapping("hi/{name}")
    public String hi(@PathVariable String name) {
        return hiService.hiService(name);
    }

}
