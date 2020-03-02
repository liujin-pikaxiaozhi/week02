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

	//ע��
	@Autowired
	RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJDK() {//����Jdk
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 10000; i++) {
			//ģ������ʮ��������
			User user=new User(i, "zhangsan"+i, "Ů", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			list.add(user);
		}
		//����
		redisTemplate.opsForList().leftPushAll("mylist", list.toArray());
		System.out.println("����10��������");
		System.out.println("����JDK");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testJson() {//����JSON
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 10000; i++) {
			//ģ������ʮ��������
			User user=new User(i, "zhangsan"+i, "Ů", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			list.add(user);
		}
		//����
		redisTemplate.opsForList().leftPushAll("mylist2", list.toArray());
		System.out.println("����10��������");
		System.out.println("����Json");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testHash() {//����hash
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10000; i++) {
			//ģ������ʮ��������
			User user=new User(i, "zhangsan"+i, "Ů", "1324344"+i, i+"324342@qq.com", "10-1"+i);
			map.put("myhash"+i, user.toString());
		}
		//����
		redisTemplate.opsForHash().putAll("testHash", map);
		System.out.println("����10��������");
		System.out.println("����hash");
	}
	
}
