package net.luis.system.service.impl;

/**
*@CreateTime：2017年3月28日 下午5:10:44
*@Author sai.liu
*@ProjectPackage：net.luis.system.service.impl.LogServiceImpl.java
*@Description：
*/

import java.util.List;
import net.luis.system.dao.LogDao;
import net.luis.system.model.Log;
import net.luis.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;

	public void save(Log log) {
		this.logDao.save(log);
	}

	public Log get(Integer id) {
		return this.logDao.get(id);
	}

	public void deleteById(Integer id) {
		this.logDao.deleteById(id);
	}

	public List<Log> getListByHQL(String hql, Object[] values) {
		return null;
	}
}