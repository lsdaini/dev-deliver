package net.luis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.luis.system.model.User;
import net.luis.system.service.UserService;

/**
* Created by sai.liu on 2017年4月7日  下午4:33:48
* net.luis.security.UserAuthenticationProvider.java
*@Description：
*/

public class UserAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        User user = userService.getUserByName(username);
        
		if (user == null) {
			throw new UsernameNotFoundException("操作员未找到！");
		}
		
//		if ("0".equals(user.getEnabled())) {
//			throw new UsernameNotFoundException("操作员失效！");
//		}
		
		if (!user.getPassword().equals(password)) {
			throw new BadCredentialsException("密码不对！");
		}
		
		UserDetails loadedUser = (UserDetails) user;

//        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(loadedUser,
//                authentication.getCredentials(), user.getAuthorities());
//        result.setDetails(authentication.getDetails());
        		            
//        return result;
        return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}