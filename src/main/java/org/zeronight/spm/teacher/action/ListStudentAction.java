package org.zeronight.spm.teacher.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class ListStudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students;
	@Autowired
	private ITeacherService teacherService;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String execute() throws Exception {
		students = teacherService.getAllStudents();
		return SUCCESS;
	}
}
