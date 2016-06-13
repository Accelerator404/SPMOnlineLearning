package org.zeronight.spm.teacher.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class StudentChangeGroupAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer studentId;
	private List<StudentGroup> groups;
	private Integer groupId;
	@Autowired
	private ITeacherService teacherService;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public List<StudentGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<StudentGroup> groups) {
		this.groups = groups;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	@Override
	public String execute() throws Exception {
		if(groupId==null||groupId==0){
			groups = teacherService.getAllGroup();
			return INPUT;
		}
		else{
			teacherService.AddStudentToGroup(groupId, studentId);
			return SUCCESS;
		}
	}
	
}
