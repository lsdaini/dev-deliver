package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:11:53
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.UserServiceImpl.java
*@Description：
*/

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.UserDao;
import net.luis.system.model.User;
import net.luis.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseService<User, Integer> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public HibernateBaseDao<User, Integer> getEntityDao() {
		return userDao;
	}

	@Override
	public User getUserByName(String username) {
		return null;
	}
}