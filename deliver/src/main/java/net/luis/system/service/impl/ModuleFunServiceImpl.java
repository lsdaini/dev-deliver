package net.luis.system.service.impl;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import net.luis.system.dao.ModuleFunDao;
import net.luis.system.model.ModuleFun;
import net.luis.system.service.ModuleFunService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuleFunServiceImpl extends BaseService<ModuleFun, Integer> implements  ModuleFunService {

	@Autowired
	private  ModuleFunDao  moduleFunDao;

	@Override
	public HibernateBaseDao<ModuleFun, Integer> getEntityDao() {
		return moduleFunDao;
	}

}