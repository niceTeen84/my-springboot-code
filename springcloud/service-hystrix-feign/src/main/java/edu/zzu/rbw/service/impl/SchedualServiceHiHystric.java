package edu.zzu.rbw.service.impl;

import edu.zzu.rbw.service.SchedualServiceHi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements FallbackFactory<SchedualServiceHi>{

    @Override
    public SchedualServiceHi create(Throwable throwable) {
        return new SchedualServiceHi() {
            @Override
            public String sayHiFromCLientOne(String name) {
                return "Oops sth has cllopse ... " + name;
            }
        };
    }
}
