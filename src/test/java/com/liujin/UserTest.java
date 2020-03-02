package com.liujin;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:redis.xml")
public class UserTest {

	//注入
	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJDK() {//测试Jdk
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 10000; i++) {
			//模拟生成十万条数据
			User user=new User(i, "zhangsan"+i, "女", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			list.add(user);
		}
		//存入
		redisTemplate.opsForList().leftPushAll("mylist", list.toArray());
		System.out.println("生成10万条数据");
		System.out.println("测试JDK");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJson() {//测试JSON
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 10000; i++) {
			//模拟生成十万条数据
			User user=new User(i, "zhangsan"+i, "女", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			list.add(user);
		}
		//存入
		redisTemplate.opsForList().leftPushAll("mylist2", list.toArray());
		System.out.println("生成10万条数据");
		System.out.println("测试Json");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testHash() {//测试hash
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10000; i++) {
			//模拟生成十万条数据
			User user=new User(i, "zhangsan"+i, "女", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			map.put("myhash"+i, user.toString());
		}
		//存入
		redisTemplate.opsForHash().putAll("testHash", map);
		System.out.println("生成10万条数据");
		System.out.println("测试hash");
	}
	
}
