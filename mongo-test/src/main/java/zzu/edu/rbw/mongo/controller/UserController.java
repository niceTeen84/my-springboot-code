package zzu.edu.rbw.mongo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zzu.edu.rbw.mongo.entity.User;
import zzu.edu.rbw.mongo.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(maxAge = 3600)
    @GetMapping("get-all")
    public Map<String, Object> getAllUserInfo() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        try {
            List<User> list = userService.findAll();
            map.put("data", list);
            map.put("status", "200");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Oops Sth Wrong!{}", "数据交互");
            map.put("data", null);
            map.put("status", "500");
            return map;
        }
    }
}
