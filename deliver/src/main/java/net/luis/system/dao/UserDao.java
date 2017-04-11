package net.luis.system.dao;

import net.luis.common.dao.HibernateBaseDao;
import net.luis.system.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends HibernateBaseDao<User, Integer>{
	public User getUserByName(String userName){
		return null;
		
	}
}
