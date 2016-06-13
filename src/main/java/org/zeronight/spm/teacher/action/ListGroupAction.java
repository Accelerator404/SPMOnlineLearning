package org.zeronight.spm.teacher.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class ListGroupAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<StudentGroup> groups;
	private String errorMessage;
	@Autowired
	private ITeacherService teacherService;
	public List<StudentGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<StudentGroup> groups) {
		this.groups = groups;
	}
	@Override
	public String execute() throws Exception {
		groups = teacherService.getAllGroup();
		return SUCCESS;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
