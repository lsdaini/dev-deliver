package net.luis.system.service;

import java.util.List;

import net.luis.system.model.Rights;

/**
* Created by sai.liu on 2017年4月7日  下午5:25:12
* net.luis.system.service.RightsService.java
*@Description：
*/

public interface RightsService {
	public void save(Rights rights);

	public Rights get(Integer id);

	public void deleteById(Integer id);

	public List<Rights> getListByHQL(String hql, Object[] params);
}
