package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.ModuleDao;
import net.luis.system.model.Module;
import net.luis.system.service.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuleServiceImpl extends BaseService<Module, Integer> implements  ModuleService {

	@Autowired
	private  ModuleDao  moduleDao;

	@Override
	public HibernateBaseDao<Module, Integer> getEntityDao() {
		return moduleDao;
	}

}