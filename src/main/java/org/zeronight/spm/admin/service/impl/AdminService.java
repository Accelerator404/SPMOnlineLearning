package org.zeronight.spm.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeronight.spm.admin.service.IAdminService;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.User;

@Service("adminService")
public class AdminService implements IAdminService {
	
	@Autowired
	private IBaseDao<User> userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.find("from User");
	}

	@Override
	public boolean updateUser(User user) {
		userDao.update(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		userDao.delete(user);
		return true;
	}

	@Override
	public boolean createUser(User user) {
		userDao.save(user);
		return true;
	}

	@Override
	public User getUserByUsername(String username) {
		List<Object> param=new ArrayList<Object>();
		param.add(username);
		return userDao.get("from User where username=?", param);
	}

}
