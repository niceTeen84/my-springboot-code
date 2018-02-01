package zzu.edu.rbw.mongo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import zzu.edu.rbw.mongo.entity.User;

import java.util.Date;
import java.util.List;


public interface UserRepository extends MongoRepository<User, String>, CrudRepository<User, String>{
    List<User> findByAgeGreaterThan(Integer age);
    List<User> findByBirthdayBetween(Date start, Date end);
    Page<User> findAll(Pageable pageable);
    List<User> findAll(Sort sort);
    List<User> findAllByNameLike(String likeName);
    List<User> findByNameLikeAndAgeBetween(String likeName, int stAge, int edAge);
    List<User> findAllByNameLikeAndAgeGreaterThanOrderByAge(String likeName, int age);
}

