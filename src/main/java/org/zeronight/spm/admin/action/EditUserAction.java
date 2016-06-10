package org.zeronight.spm.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.admin.service.IAdminService;
import org.zeronight.spm.model.Role;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class EditUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String roleName;
	private String email;
	private String phoneNumber;
	private String name;
	@Autowired
	private IAdminService adminService;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String execute() throws Exception {
		User user = adminService.getUserById(id);
		user.setEmail(email);
		user.setName(name);
		user.setPhoneNumber(phoneNumber);
		Role role = adminService.getRoleByRolename(roleName);
		user.setRole(role);
		if(roleName=="ROLE_STUDENT"&&user.getStudent()==null){
			Student student = new Student();
			adminService.addStudent(student);
			user.setStudent(student);
		}
		if(roleName=="ROLE_TEACHER"&&user.getStudent()!=null){
			Student student = user.getStudent();
			user.setStudent(null);
			adminService.deleteStudent(student);
		}
		adminService.updateUser(user);
		return SUCCESS;
	}

}
