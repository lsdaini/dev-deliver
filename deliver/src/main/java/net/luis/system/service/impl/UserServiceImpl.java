package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:11:53
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.UserServiceImpl.java
*@Description：
*/

import java.util.List;
import net.luis.system.dao.UserDao;
import net.luis.system.model.User;
import net.luis.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public void save(User user) {
		this.userDao.save(user);
	}

	public User get(Integer id) {
		return this.userDao.get(id);
	}

	public void deleteById(Integer id) {
		this.userDao.deleteById(id);
	}

	public List<User> getListByHQL(String hql, Object[] values) {
		return null;
	}

	@Override
	public User getUserByName(String userName) {
		return null;
	}
}