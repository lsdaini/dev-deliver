package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.common.service.BaseService;
import net.luis.system.dao.RightsDao;
import net.luis.system.model.Rights;
import net.luis.system.service.RightsService;

@Service
@Transactional
public class RightsServiceImpl extends BaseService<Rights, Integer> implements RightsService {

	@Autowired
	private RightsDao rightsDao;

	@Override
	public HibernateBaseDao<Rights, Integer> getEntityDao() {
		return rightsDao;
	}

}