package net.luis.system.service;

import java.util.List;

import net.luis.system.model.Role;

/**
* Created by sai.liu on 2017年4月7日  下午5:22:23
* net.luis.system.service.RoleService.java
*@Description：
*/

public interface RoleService {
	public void save(Role role);

	public Role get(Integer id);

	public void deleteById(Integer id);

	public List<Role> getListByHQL(String hql, Object[] params);
}
