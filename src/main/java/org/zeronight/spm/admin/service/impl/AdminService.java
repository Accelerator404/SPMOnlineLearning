package org.zeronight.spm.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeronight.spm.admin.service.IAdminService;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.Role;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.User;

@Service("adminService")
public class AdminService implements IAdminService {
	
	@Autowired
	private IBaseDao<User> userDao;
	
	@Autowired
	private IBaseDao<Role> roleDao;
	
	@Autowired
	private IBaseDao<Student> studentDao;

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

	@Override
	public List<Role> getAllRoles() {
		return roleDao.find("from Role");
	}

	@Override
	public User getUserById(int Id) {
		return userDao.get(User.class, Id);
	}

	@Override
	public Role getRoleByRolename(String roleName) {
		List<Object> param = new ArrayList<Object>();
		param.add(roleName);
		return roleDao.get("from Role where roleName=?", param);
	}

	@Override
	public boolean addStudent(Student student) {
		studentDao.save(student);
		return true;
	}

	@Override
	public boolean deleteStudent(Student student) {
		studentDao.delete(student);
		return true;
	}

}
