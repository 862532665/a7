package cn.itcast.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory factory;
	
	public UserDaoImpl(SqlSessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * 保存
	 * 		insert：
	 * 			statement（mapperId） ： namespece.id（sql的唯一标识）
	 * 			parameter：输入参数
	 */
	public void save(User user) {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.通过sqlSession的方法完成保存
		session.insert("aaa.saveUser", user);
		//3.提交事务
		session.commit();
		session.close();
	}

	/**
	 * 更新
	 * 	update
	 * 		statement  ：
	 * 		parameter  ：
	 */
	public void update(User user) {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.调用sqlSession的方法完成更新操作
		session.update("aaa.updateUser", user);
		//3.提交事务
		session.commit();
		session.close();
	}

	/**
	 * 删除
	 */
	public void delete(int id) {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.使用sqlSession的方法完成删除操作
		session.delete("aaa.deleteUser", id);
		//3.提交事务
		session.commit();
		session.close();
	}

	/**
	 * 根据id查询
	 * 		返回值只有一个对象
	 */
	public User findUserById(int id) {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.使用sqlSession的方法完成查询一个对象
		return session.selectOne("aaa.findById", id);		
	}

	/**
	 * 模糊查询：
	 * 	返回值是一个list集合
	 */
	public List<User> findUsersByName(String name) {
		//1.获取sqlSession
		SqlSession session = factory.openSession();
		//2.使用sqlSession的方法完成查询返回list集合
		return session.selectList("aaa.findByName", name);
	}

}
