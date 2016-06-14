package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Server;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class EditServerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Server server;
	private Integer serverId;
	private String name;
	private String linkAddress;
	@Autowired
	private ITeacherService teacherService;

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

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
		server = teacherService.gerServerById(serverId);
		if(linkAddress==null||name==null)return INPUT;
		server.setLinkAddress(linkAddress);
		server.setName(name);
		try{
			teacherService.updateServer(server);
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

}
