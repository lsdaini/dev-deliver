package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.luis.system.dao.RightsDao;
import net.luis.system.model.Rights;
import net.luis.system.service.RightsService;

@Service
@Transactional
public class RightsServiceImpl implements RightsService {

	@Autowired
	private RightsDao rightsDao;

	public void save(Rights rights) {
		this.rightsDao.save(rights);
	}

	public Rights get(Integer id) {
		return this.rightsDao.get(id);
	}

	public void deleteById(Integer id) {
		this.rightsDao.deleteById(id);
	}

	public List<Rights> getListByHQL(String hql, Object[] values) {
		return null;
	}
}