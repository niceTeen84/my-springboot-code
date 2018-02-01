package edu.zzu.rbw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @return
     */
    public String hiService(String name) {
        return restTemplate.getForObject("http://SPRING-CLOUD-CLI/hi/" + name, String.class);
    }

}
