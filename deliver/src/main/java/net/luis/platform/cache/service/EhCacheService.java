package net.luis.platform.cache.service;

import java.util.List;

/**
 * @CreateTime：2017年3月28日 下午5:03:18
 * @Author sai.liu
 * @ProjectPackage：net.luis.platform.cache.service.EhCacheService.java @Description：
 */

public interface EhCacheService {
	
	public String getTimestamp(String paramString);

	public List<String> getStrList();
}
