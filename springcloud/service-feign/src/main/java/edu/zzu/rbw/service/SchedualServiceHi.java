package edu.zzu.rbw.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "spring-cloud-cli")
public interface SchedualServiceHi {

    @GetMapping("hi/{name}")
    String sayHello(@PathVariable(value = "name") String name);

}
