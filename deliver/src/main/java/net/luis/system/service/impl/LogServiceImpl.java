package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.LogDao;
import net.luis.system.model.Log;
import net.luis.system.service.LogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl extends BaseService<Log, Integer> implements LogService{

	@Autowired
	private LogDao logDao;

	@Override
	public HibernateBaseDao<Log, Integer> getEntityDao() {
		return logDao;
	}

}