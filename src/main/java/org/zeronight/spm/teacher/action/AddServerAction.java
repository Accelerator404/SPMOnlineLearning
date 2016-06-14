package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Server;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class AddServerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String linkAddress;
	private String name;
	@Autowired
	private ITeacherService teacherService;
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String execute() throws Exception {
		Server server = new Server();
		server.setLinkAddress(linkAddress);
		server.setName(name);
		server.setAvailable(true);
		try{
			teacherService.addServer(server);
			return SUCCESS;
		}catch(Exception e){
			return INPUT;
		}
	}
}
