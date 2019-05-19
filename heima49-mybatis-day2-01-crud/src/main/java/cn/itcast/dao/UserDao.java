package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {

	/**
	 * 保存用户
	 * 	输入参数：用户对象
	 */
	public void saveUser(User user);
	
	/**
	 * 更新用户
	 * 	案例：根据用户id，更新用户的基本属性
	 */
	public int updateUser(User user);
	
	/**
	 * 根据id删除
	 * 	输入参数：基本数据类型
	 */
	public void deleteUser(int id);
	
	/**
	 * 根据id查询
	 */
	public User findById(int id);
	
	/**
	 * 模糊查询
	 */
	public List<User> findByName(String username);
}
