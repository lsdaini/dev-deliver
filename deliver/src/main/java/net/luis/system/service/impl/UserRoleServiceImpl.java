package net.luis.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.UserRoleDao;
import net.luis.system.model.UserRole;
import net.luis.system.service.UserRoleService;

/**
* Created by sai.liu on 2017年4月7日  下午5:30:50
* net.luis.system.service.impl.RoleServiceImpl.java
*@Description：
*/

@Service
@Transactional
public class UserRoleServiceImpl extends BaseService<UserRole, Integer> implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	@Override
	public HibernateBaseDao<UserRole, Integer> getEntityDao() {
		return userRoleDao;
	}

}
