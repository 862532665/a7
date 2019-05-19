package cn.itcast.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.dao.UserDao;
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
	public void testSaveUser() throws Exception {
		//1.创建sqlSession
		SqlSession session = factory.openSession();
		//2.创建dao接口的动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		//3.测试
		User user = new User();
		user.setUsername("大老王-03");
		user.setBirthday(new Date());
		user.setSex("女");
		user.setAddress("shunyi");
		userDao.saveUser(user);
		
		//4.事务提交
		session.commit();
		session.close();//释放资源
		
		System.out.println("保存的id主键值 = " +user.getId());
	}
	
	/**
	 * 测试更新
	 */
	@Test
	public void testUpdateUser() {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.创建动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		//3.测试
		User user = new User();
		user.setId(1111);
		user.setUsername("小老王");
		user.setSex("男");
		user.setAddress("地球");
		int count = userDao.updateUser(user);
		System.out.println(count);
		//4.提交
		session.commit();
		session.close();//释放资源
	}
	
	@Test
	public void testDelete() {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.创建动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		
		userDao.deleteUser(129);
		
		//4.提交
		session.commit();
		session.close();//释放资源
	}
	
	
	@Test
	public void testFindById() {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.创建动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		
		User user = userDao.findById(129);
		System.out.println(user);
	}
	
	@Test
	public void testFindByName() {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.创建动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		
		List<User> list = userDao.findByName("select * from user");
		for (User user : list) {
			System.out.println(user);
		}
	}
}
