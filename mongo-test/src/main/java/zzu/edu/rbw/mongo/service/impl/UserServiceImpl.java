package zzu.edu.rbw.mongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzu.edu.rbw.mongo.dao.UserRepository;
import zzu.edu.rbw.mongo.entity.User;
import zzu.edu.rbw.mongo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
