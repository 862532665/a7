package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

public interface UserDao {

	public void save(User user);//保存
	
	public void update(User user);//更新
	
	public void delete(int id);//删除
	
	public User findUserById(int id);//根据id查询
	
	public List<User> findUsersByName(String name);//模糊查询
}
