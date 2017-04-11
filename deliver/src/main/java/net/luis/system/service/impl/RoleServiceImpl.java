package net.luis.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.luis.system.dao.RoleDao;
import net.luis.system.model.Role;
import net.luis.system.service.RoleService;

/**
* Created by sai.liu on 2017年4月7日  下午5:30:50
* net.luis.system.service.impl.RoleServiceImpl.java
*@Description：
*/

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void save(Role role) {
		this.roleDao.save(role);
	}

	@Override
	public Role get(Integer id) {
		return this.roleDao.get(id);
	}

	@Override
	public void deleteById(Integer id) {
		this.roleDao.deleteById(id);
	}

	@Override
	public List<Role> getListByHQL(String hql, Object[] params) {
		return null;
	}

}
