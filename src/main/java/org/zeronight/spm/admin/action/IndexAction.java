package org.zeronight.spm.admin.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.zeronight.spm.admin.service.IAdminService;
import org.zeronight.spm.model.User;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IAdminService adminService;
	private List<User> users;
	private String currentUser;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String execute() throws Exception {
		users = adminService.getAllUsers();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			currentUser = ((UserDetails) principal).getUsername();
		} else {
			currentUser = principal.toString();
		}
		return SUCCESS;
	}

	public String getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}
}
