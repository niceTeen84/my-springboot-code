package zzu.edu.rbw.mongo.service;

import zzu.edu.rbw.mongo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
