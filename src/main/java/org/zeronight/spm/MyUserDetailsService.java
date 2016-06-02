package org.zeronight.spm;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.User;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IBaseDao<User> userDao;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		List<Object> param = new ArrayList<Object>();
		param.add(arg0);
		User user = userDao.get("from User where username=?", param);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(), authorities);
	}

}
