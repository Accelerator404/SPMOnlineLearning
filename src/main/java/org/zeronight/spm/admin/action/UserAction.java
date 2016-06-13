package org.zeronight.spm.admin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.admin.service.IAdminService;
import org.zeronight.spm.model.Role;
import org.zeronight.spm.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAdminService adminService;
	private int id;
	private User user;
	private List<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String execute() throws Exception {
		user=adminService.getUserById(id);
		roles=adminService.getAllRoles();
		return SUCCESS;
	}
}
