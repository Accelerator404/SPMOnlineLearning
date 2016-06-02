package org.zeronight.spm.admin.service;

import java.util.List;

import org.zeronight.spm.model.User;

public interface IAdminService {
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public boolean createUser(User user);
	public User getUserByUsername(String username);
}
