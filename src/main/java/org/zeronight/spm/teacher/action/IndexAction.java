package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long studentAmount;
	private Long groupAmount;
	private Long workAmount;
	@Autowired
	private ITeacherService teacherService;

	public Long getStudentAmount() {
		return studentAmount;
	}

	public void setStudentAmount(Long studentAmount) {
		this.studentAmount = studentAmount;
	}

	public Long getGroupAmount() {
		return groupAmount;
	}

	public void setGroupAmount(Long groupAmount) {
		this.groupAmount = groupAmount;
	}

	public Long getWorkAmount() {
		return workAmount;
	}

	public void setWorkAmount(Long workAmount) {
		this.workAmount = workAmount;
	}

	@Override
	public String execute() throws Exception {
		groupAmount = teacherService.getGroupAmount();
		workAmount = teacherService.getWorkAmount();
		studentAmount = teacherService.getStudentAmount();
		return SUCCESS;
	}
}
