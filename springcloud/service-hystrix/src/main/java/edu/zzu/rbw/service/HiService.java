package edu.zzu.rbw.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiErro")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SPRING-CLOUD-CLI/hi/" + name, String.class);
    }

    public String hiErro(String name) {
        StringBuilder builder = new StringBuilder();
        builder.append("hi ").append(name).append(", sorry! sth erro!");
        return builder.toString();
    }
}
