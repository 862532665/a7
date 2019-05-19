package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.User;

public class UserDaoTest {

	private SqlSessionFactory factory;
	
	
	@Before
	public void init() throws IOException {
		//1.加载配置文件
		InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.创建sqlSessionFactoryBulder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//3.创建sessionfactory
		factory = builder.build(is);
	}
	
	/**
	 * 测试保存
	 * @throws Exception 
	 */
	@Test
	public void testSave() throws Exception {
		//创建dao
		UserDao userDao = new UserDaoImpl(factory);
		//保存
		User user = new User();
		user.setUsername("大老王-00");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("shunyi");
		
		userDao.save(user);
		
		System.out.println("保存的id主键值 = " +user.getId());
	}
	
	@Test
	public void testUpdate() {
		//创建dao
		UserDao userDao = new UserDaoImpl(factory);
		User user = new User();
		user.setUsername("00");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("北京");
		user.setId(132);
		userDao.update(user);
	}
	
	@Test
	public void testDelete() {
		//创建dao
		UserDao userDao = new UserDaoImpl(factory);
		userDao.delete(132);
	}
	
	@Test
	public void testFindById() {
		//创建dao
		UserDao userDao = new UserDaoImpl(factory);
		User user = userDao.findUserById(129);
		System.out.println(user);
	}
	
	@Test
	public void testFindByName() {
		//创建dao
		UserDao userDao = new UserDaoImpl(factory);
		List<User> list = userDao.findUsersByName("%王%");
		for (User user : list) {
			System.out.println(user);
		}
	}
	
}
