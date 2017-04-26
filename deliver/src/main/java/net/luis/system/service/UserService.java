package net.luis.system.service;

import net.luis.system.model.User;

/**
 * @CreateTime：2017年3月28日 下午5:10:08
 * @Author sai.liu
 * @ProjectPackage：net.luis.system.service.UserService.java @Description：
 */

public interface UserService{

	public User getUserByName(String username);
	
}
