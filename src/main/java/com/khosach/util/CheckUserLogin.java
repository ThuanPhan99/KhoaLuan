/*
 * @author THUAN-PHAN
 * @date May 24, 2020
 * @version 1.0
 */

package com.khosach.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CheckUserLogin {
	
	public boolean checkUser() {
		 return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails;
	}
}
