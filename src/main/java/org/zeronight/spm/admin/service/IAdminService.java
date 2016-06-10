package org.zeronight.spm.admin.service;

import java.util.List;

import org.zeronight.spm.model.Role;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.User;

public interface IAdminService {
	public List<Role> getAllRoles();
	public User getUserById(int Id);
	public List<User> getAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public boolean createUser(User user);
	public User getUserByUsername(String username);
	public Role getRoleByRolename(String roleName);
	public boolean addStudent(Student student);
	public boolean deleteStudent(Student student);
}
