package org.zeronight.spm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Work")
public class Work implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String project;
	private String requirement;
	private String generalDesign;
	private String detailedDesign;
	private int deployPoint;
	private int indexPoint;
	private int linkPoint;
	private int functionPoint;
	private int performancePoint;
	private int stylePoint;
	private int codePoint;
	private int autoDocPoint;
	private int manualDocPoint;
	private StudentGroup studentGroup;
	private Set<TestCase> testCases;
	public Work(){
		
	}
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getGeneralDesign() {
		return generalDesign;
	}
	public void setGeneralDesign(String generalDesign) {
		this.generalDesign = generalDesign;
	}
	public String getDetailedDesign() {
		return detailedDesign;
	}
	public void setDetailedDesign(String detailedDesign) {
		this.detailedDesign = detailedDesign;
	}
	public int getDeployPoint() {
		return deployPoint;
	}
	public void setDeployPoint(int deployPoint) {
		this.deployPoint = deployPoint;
	}
	public int getIndexPoint() {
		return indexPoint;
	}
	public void setIndexPoint(int indexPoint) {
		this.indexPoint = indexPoint;
	}
	public int getLinkPoint() {
		return linkPoint;
	}
	public void setLinkPoint(int linkPoint) {
		this.linkPoint = linkPoint;
	}
	public int getFunctionPoint() {
		return functionPoint;
	}
	public void setFunctionPoint(int functionPoint) {
		this.functionPoint = functionPoint;
	}
	public int getPerformancePoint() {
		return performancePoint;
	}
	public void setPerformancePoint(int performancePoint) {
		this.performancePoint = performancePoint;
	}
	public int getStylePoint() {
		return stylePoint;
	}
	public void setStylePoint(int stylePoint) {
		this.stylePoint = stylePoint;
	}
	public int getCodePoint() {
		return codePoint;
	}
	public void setCodePoint(int codePoint) {
		this.codePoint = codePoint;
	}
	public int getAutoDocPoint() {
		return autoDocPoint;
	}
	public void setAutoDocPoint(int autoDocPoint) {
		this.autoDocPoint = autoDocPoint;
	}
	public int getManualDocPoint() {
		return manualDocPoint;
	}
	public void setManualDocPoint(int manualDocPoint) {
		this.manualDocPoint = manualDocPoint;
	}
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentGroup_id")
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public Set<TestCase> getTestCases() {
		return testCases;
	}
	public void setTestCases(Set<TestCase> testCases) {
		this.testCases = testCases;
	}
}
