package net.luis.system.service;

import java.util.List;

import net.luis.system.model.User;

/**
 * @CreateTime：2017年3月28日 下午5:10:08
 * @Author sai.liu
 * @ProjectPackage：net.luis.system.service.UserService.java @Description：
 */

public interface UserService {
	public  void save(User user);

	public  User get(Integer id);

	public  void deleteById(Integer id);

	public  List<User> getListByHQL(String hql, Object[] params);
	
	public User getUserByName(String userName);
}
