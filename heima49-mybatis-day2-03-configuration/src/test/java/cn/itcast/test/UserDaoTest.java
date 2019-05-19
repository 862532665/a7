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
	public void testGetCount() throws Exception {
		//1.创建sqlSession
		SqlSession session = factory.openSession();
		//2.创建dao接口的动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		//3.测试
		int count = userDao.getCount();
		
		System.out.println(count);
	}
	
	/**
	 * 测试保存
	 * @throws Exception 
	 */
	@Test
	public void testFindAllUser() throws Exception {
		//1.创建sqlSession
		SqlSession session = factory.openSession();
		//2.创建dao接口的动态代理对象
		UserDao userDao = session.getMapper(UserDao.class);
		//3.测试
		List<User> list = userDao.findAllUser();
		for (User user : list) {
			System.out.println(user);
		}
	}

}
