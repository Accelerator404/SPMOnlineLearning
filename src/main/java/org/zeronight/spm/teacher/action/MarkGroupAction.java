package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class MarkGroupAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer groupId;
	private Integer point;
	@Autowired
	private ITeacherService teacherService;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String execute() throws Exception {
		if(point==null)return INPUT;
		StudentGroup group = teacherService.getGroupById(groupId);
		group.setPoint(point);
		return SUCCESS;
	}
}
