package edu.zzu.rbw.service;

import edu.zzu.rbw.service.impl.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "spring-cloud-cli", fallbackFactory = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping("hi/{name}")
    String sayHiFromCLientOne(@PathVariable(value = "name") String name);
}
