package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class AddGroupAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private static String errorMessage = "组名为空或者组名不存在！";
	@Autowired
	private ITeacherService teacherService;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		try{
			StudentGroup group=new StudentGroup(name);
			teacherService.AddGroup(group);
			return SUCCESS;
		}catch(Exception e){
			return INPUT;
		}
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
	public static void setErrorMessage(String errorMessage) {
		AddGroupAction.errorMessage = errorMessage;
	}
}
