package zzu.edu.rbw.mongo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import zzu.edu.rbw.mongo.dao.UserRepository;
import zzu.edu.rbw.mongo.entity.State;
import zzu.edu.rbw.mongo.entity.Type;
import zzu.edu.rbw.mongo.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoApplicationTests {

	@Autowired
	private UserRepository userRepository;


	/*@Before
	public void contextLoads() {
		userRepository.deleteAll();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId(UUID.randomUUID().toString().replace("-", ""));
			user.setAge(i + new Random().nextInt(10));
			if (i % 2 == 0) {
				user.setName("xiaoming" + i);
			} else {
				user.setName("tom" + i);
			}
			user.setBirthday(new Date());
			userRepository.insert(user);
		}
	}*/

	@Test
	public void testCount() {
		long count = userRepository.count();
		Assert.assertEquals(9, count);
	}

	@Test
	public void testSelect() {
		List<User> all = userRepository.findByAgeGreaterThan(10);
		Assert.assertEquals(3, all.size());
	}

	@Test
	public void testSelect1() {
		String testId = "925d29d6c44d4d65bf58f4e8cbaec8da";
		Optional<User> byId = userRepository.findById(testId);
		Assert.assertEquals("xiaoming0", byId.get().getName());
	}

	@Test
	public void testSelect1_1() {
		String testId = "925d29d6c44d4d65bf58f4e8cbaec8das";
		Optional<User> byId = userRepository.findById(testId);
		Assert.assertFalse(byId.isPresent());
		//Assert.assertNull(byId);
		//Assert.assertNull(byId.get());
	}

	@Test
	public void testSelect2() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date start = dateFormat.parse("2018-01-19");
			Date end = dateFormat.parse("2018-01-26");
			List<User> list = userRepository.findByBirthdayBetween(start, end);
			Assert.assertNotNull(list);
			Assert.assertEquals(4, list.size());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelect3() {
		List<User> all = userRepository.findAll();
		for (User user : all) {
			System.out.println(user);
		}
		Assert.assertEquals(10, all.size());
	}

	@Test
	public void testSelect4() {
		// userRepository.deleteAll(userRepository.findByAgeGreaterThan(10));
		// userRepository.exists()
		// userRepository.deleteAll();
		Assert.assertEquals(9, userRepository.count());
	}

	/**
	 * test page
	 */
	@Test
	public void testSelect5() {
		Sort sort = new Sort(Sort.Direction.DESC, "age");
		PageRequest pageRequest = PageRequest.of(1, 20, sort);
		//List<User> all2 = userRepository.findAll(sort);
		Page<User> all2 = userRepository.findAll(pageRequest);
		for (User user : all2) {
			log.info("名字{}, 年龄{}, 生日{}", user.getName(), user.getAge(), user.getBirthday());
		}
		Assert.assertEquals(100, all2.getTotalElements());
	}

	@Test
	public void testSelect6() {
		/*User user = new User();
		user.setName("xiaoming");
		Example<User> example = Example.of(user);*/
		List<User> all = userRepository.findAllByNameLike("xiaoming");
		System.out.println(all.size());
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setId("cae001f3d05a494ab01616af14b5329c");
		user.setName("江蛤蟆kkkk");
		/*user.setAge(100);
		user.setBirthday(new Date());*/
		userRepository.save(user);
		//Assert.assertEquals();
		log.info("总数量{}", userRepository.count());
	}

	@Test
	public void testQueryExample() {
		User user = new User();
		user.setAge(39);
		Example<User> example = Example.of(user);
		List<User> all = userRepository.findAll(example);
		for (User user1 : all) {
			log.info("名字{}, 年龄{}, 生日{}", user1.getName(), user1.getAge(), user1.getBirthday());
		}
	}

	@Test
	public void testQueryCretor() {
		List<User> xiao = userRepository.findByNameLikeAndAgeBetween("xiao", 20, 39);
		for (User user : xiao) {
			log.info("名字{}, 年龄{}, 生日{}", user.getName(), user.getAge(), user.getBirthday());
		}
		System.out.println(xiao.size());
	}

	@Test
	public void testQueryCreator() {
		List<User> userList = userRepository.findAllByNameLikeAndAgeGreaterThanOrderByAge(null, 50);
		for (User user : userList) {
			log.info("名字{}, 年龄{}, 生日{}", user.getName(), user.getAge(), user.getBirthday());
		}
	}

	@Test
	public void testInsert() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId(UUID.randomUUID().toString().replace("-", ""));
			user.setAge(i + new Random().nextInt(10));
			String[] arr = {"yyy", "iii"};
			user.setTag(arr);
			user.setType(new Type("sb", 180 + i));
			if (i % 2 == 0) {
				user.setName("xiaoming" + i);
				user.setState(State.ACTIVE.ordinal());
			} else {
				user.setName("tom" + i);
				user.setState(State.SLIENCE.ordinal());
			}
			user.setBirthday(new Date());
			userRepository.save(user);
		}
		long end = System.currentTimeMillis();
		log.info("一共耗时{}", (end - start));
	}

	@Test
	public void testSelect11() {
		long start = System.currentTimeMillis();
		List<User> all = userRepository.findAll();
		/*Optional<User> ahdas = userRepository.findById("ahdas");
		ahdas.filter(x -> System.out::println);*/
		long end = System.currentTimeMillis();
		log.info("一共耗时{}", (end - start));
	}

	@Test
	public void testQuery3() {
		User user = new User();
		user.setName("xiaoming");
		user.setAge(18);
		Example<User> example = Example.of(user);
		userRepository.findAll(example);
	}

	@Test
	public void testQueryById() {
		Optional<User> byId = userRepository.findById("6c470ee6c2c746739e6588ac42898419");
//		System.out.println(byId.get());
		User user = new User();
		BeanUtils.copyProperties(byId.get(), user);
		System.out.println(user);
	}

	@Test
	public void testUpdateUser() {
		Optional<User> byId = userRepository.findById("312a2a84f2a145c499a9a45e5a8ed188");
		User user = new User();
		BeanUtils.copyProperties(byId.get(), user);
		user.setName("癞蛤蟆233");
		userRepository.save(user);
		StringUtils.isEmpty(user.getName());
		Assert.assertEquals(100, userRepository.count());
	}
}
