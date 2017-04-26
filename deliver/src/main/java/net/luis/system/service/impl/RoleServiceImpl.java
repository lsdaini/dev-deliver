package net.luis.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.RoleDao;
import net.luis.system.model.Role;
import net.luis.system.service.RoleService;

/**
* Created by sai.liu on 2017年4月7日  下午5:30:50
* net.luis.system.service.impl.RoleServiceImpl.java
*@Description：
*/

@Service
@Transactional
public class RoleServiceImpl extends BaseService<Role, Integer> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public HibernateBaseDao<Role, Integer> getEntityDao() {
		return roleDao;
	}

}
