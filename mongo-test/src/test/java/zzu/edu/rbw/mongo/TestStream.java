package zzu.edu.rbw.mongo;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;
import zzu.edu.rbw.mongo.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

/**
* @Author: RenBowen
* @Date 2018/1/19/019 8:48
*/
@Slf4j
public class TestStream {

    @Test
    public void testStream4List() {
        String strLike = null;
        String name = "xiao";
        Integer age = 20;
        ArrayList<User> objects = new ArrayList<>();
        ArrayList<User> list = Lists.newArrayList(
                new User("adsa0", "xiaoming0", new Date(), 18, null, null, null),
                new User("adsa1", "xiaoming1", new Date(), 34, null, null, null),
                new User("adsa2", "xiaoming2", new Date(), 81, null, null, null),
                new User("adsa3", "tom3", new Date(), 23, null, null, null),
                new User("adsa4", "xiaoming4", new Date(), 25, null, null, null),
                new User("adsa5", "xiaoming5", new Date(), 30, null, null, null),
                new User("adsa6", "tom6", new Date(), 24, null, null, null)
        );
        Stream<User> stream = list.stream();
        if (!StringUtils.isEmpty(name)) {
            stream.filter(user -> user.getName().contains(name));

        }
        if (age != null) {
            stream.filter(user -> user.getAge() > age);
        }
        stream.forEach(objects::add);
        for (User user : list) {
            log.info("name:{}, age:{}", user.getName(), user.getAge());
        }

        for (User user : objects) {
            log.info("name:{}, age:{}", user.getName(), user.getAge());
        }

    }
}
