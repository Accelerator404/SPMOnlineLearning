package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class GroupDeleteStudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private Integer groupId;
	@Autowired
	private ITeacherService teacherService;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	@Override
	public String execute() throws Exception {
		Student student = teacherService.getStudentById(studentId);
		student.setStudentGroup(null);
		teacherService.UpdateStudent(student);
		return SUCCESS;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
}
