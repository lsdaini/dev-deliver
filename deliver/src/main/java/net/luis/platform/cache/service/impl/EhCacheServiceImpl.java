package net.luis.platform.cache.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.luis.platform.cache.service.EhCacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @CreateTime：2017年3月28日 下午5:04:13
 * @Author sai.liu
 * @ProjectPackage：net.luis.platform.cache.service.impl.EhCacheServiceImpl.java @Description：
 */

@Service
public class EhCacheServiceImpl implements EhCacheService {
	
	@Cacheable(value = { "delivercache" }, key = "#param")
	public String getTimestamp(String param) {
		Long timestamp = Long.valueOf(System.currentTimeMillis());
		return timestamp.toString();
	}

	@Cacheable({ "delivercache" })
	public List<String> getStrList() {
		List list = new ArrayList();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("44");
		return list;
	}
}
