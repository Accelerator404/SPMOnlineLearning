package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Server;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteServerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@Autowired
	private ITeacherService teacherService;
	@Override
	public String execute() throws Exception {
		Server server = teacherService.gerServerById(id);
		teacherService.delServer(server);
		return SUCCESS;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
