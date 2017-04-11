package net.luis.system.service;

import java.util.List;

import net.luis.system.model.Log;

/**
 * @CreateTime：2017年3月28日 下午5:09:21
 * @Author sai.liu
 * @ProjectPackage：net.luis.system.service.LogService.java @Description：
 */

public interface LogService {
	public void save(Log log);

	public Log get(Integer id);

	public void deleteById(Integer id);

	public List<Log> getListByHQL(String hql, Object[] params);
}
