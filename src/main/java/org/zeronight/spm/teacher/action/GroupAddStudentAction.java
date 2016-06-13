package org.zeronight.spm.teacher.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class GroupAddStudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Student> students;
	private Integer groupId;
	private Integer studentId;
	@Autowired
	private ITeacherService teacherService;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	@Override
	public String execute() throws Exception {
		if(studentId==0){
			students = teacherService.getStudentsWithNoGroup();
			return INPUT;
		}
		else{
			teacherService.AddStudentToGroup(groupId, studentId);
			return SUCCESS;
		}
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
}
