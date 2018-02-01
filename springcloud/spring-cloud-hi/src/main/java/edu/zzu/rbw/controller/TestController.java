package edu.zzu.rbw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    String port;

    @GetMapping("hi/{name}")
    public String home(@PathVariable String name) {
        StringBuilder builder = new StringBuilder();
        builder.append("hi").append(name).append("now the port is").append(port);
        return builder.toString();
    }

}
