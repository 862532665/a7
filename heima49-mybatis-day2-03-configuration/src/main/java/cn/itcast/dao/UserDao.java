package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {

	/**
	 * 查询总用户数
	 */
	public int getCount();
	
	
	public List<User> findAllUser();
}
