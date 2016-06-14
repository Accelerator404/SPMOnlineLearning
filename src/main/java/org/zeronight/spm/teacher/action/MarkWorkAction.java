package org.zeronight.spm.teacher.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.zeronight.spm.model.Work;
import org.zeronight.spm.teacher.service.ITeacherService;

import com.opensymphony.xwork2.ActionSupport;

public class MarkWorkAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer workId;
	private Work work;
	private Integer deployPoint;
	private Integer indexPoint;
	private Integer linkPoint;
	private Integer functionPoint;
	private Integer performancePoint;
	private Integer stylePoint;
	private Integer codePoint;
	private Integer autoDocPoint;
	private Integer manualDocPoint;
	@Autowired
	private ITeacherService teacherService;

	public Integer getWorkId() {
		return workId;
	}

	public void setWorkId(Integer workId) {
		this.workId = workId;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Integer getDeployPoint() {
		return deployPoint;
	}

	public void setDeployPoint(Integer deployPoint) {
		this.deployPoint = deployPoint;
	}

	public Integer getIndexPoint() {
		return indexPoint;
	}

	public void setIndexPoint(Integer indexPoint) {
		this.indexPoint = indexPoint;
	}

	public Integer getLinkPoint() {
		return linkPoint;
	}

	public void setLinkPoint(Integer linkPoint) {
		this.linkPoint = linkPoint;
	}

	public Integer getFunctionPoint() {
		return functionPoint;
	}

	public void setFunctionPoint(Integer functionPoint) {
		this.functionPoint = functionPoint;
	}

	public Integer getPerformancePoint() {
		return performancePoint;
	}

	public void setPerformancePoint(Integer performancePoint) {
		this.performancePoint = performancePoint;
	}

	public Integer getStylePoint() {
		return stylePoint;
	}

	public void setStylePoint(Integer stylePoint) {
		this.stylePoint = stylePoint;
	}

	public Integer getCodePoint() {
		return codePoint;
	}

	public void setCodePoint(Integer codePoint) {
		this.codePoint = codePoint;
	}

	public Integer getAutoDocPoint() {
		return autoDocPoint;
	}

	public void setAutoDocPoint(Integer autoDocPoint) {
		this.autoDocPoint = autoDocPoint;
	}

	public Integer getManualDocPoint() {
		return manualDocPoint;
	}

	public void setManualDocPoint(Integer manualDocPoint) {
		this.manualDocPoint = manualDocPoint;
	}

	@Override
	public String execute() throws Exception {
		work = teacherService.getWorkById(workId);
		if(deployPoint == null)return INPUT;
		work.setAutoDocPoint(autoDocPoint);
		work.setCodePoint(codePoint);
		work.setDeployPoint(deployPoint);
		work.setFunctionPoint(functionPoint);
		work.setIndexPoint(indexPoint);
		work.setLinkPoint(linkPoint);
		work.setManualDocPoint(manualDocPoint);
		work.setPerformancePoint(performancePoint);
		work.setStylePoint(stylePoint);
		teacherService.updateWork(work);
		return SUCCESS;
	}
}
