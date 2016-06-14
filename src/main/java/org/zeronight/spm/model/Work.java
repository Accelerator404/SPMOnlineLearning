package org.zeronight.spm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Work")
public class Work implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String project;
	private String sourceCode;
	private String requirement;
	private String generalDesign;
	private String detailedDesign;
	private Integer deployPoint;
	private Integer indexPoint;
	private Integer linkPoint;
	private Integer functionPoint;
	private Integer performancePoint;
	private Integer stylePoint;
	private Integer codePoint;
	private Integer autoDocPoint;
	private Integer manualDocPoint;
	private StudentGroup studentGroup;
	private Set<TestCase> testCases;

	public Work() {

	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Column(nullable=true)
	public Integer getDeployPoint() {
		return deployPoint;
	}

	public void setDeployPoint(Integer deployPoint) {
		this.deployPoint = deployPoint;
	}

	@Column(nullable=true)
	public Integer getIndexPoint() {
		return indexPoint;
	}

	public void setIndexPoint(Integer indexPoint) {
		this.indexPoint = indexPoint;
	}

	@Column(nullable=true)
	public Integer getLinkPoint() {
		return linkPoint;
	}

	public void setLinkPoint(Integer linkPoint) {
		this.linkPoint = linkPoint;
	}

	@Column(nullable=true)
	public Integer getFunctionPoint() {
		return functionPoint;
	}

	public void setFunctionPoint(Integer functionPoint) {
		this.functionPoint = functionPoint;
	}

	@Column(nullable=true)
	public Integer getPerformancePoint() {
		return performancePoint;
	}

	public void setPerformancePoint(Integer performancePoint) {
		this.performancePoint = performancePoint;
	}

	@Column(nullable=true)
	public Integer getStylePoint() {
		return stylePoint;
	}

	public void setStylePoint(Integer stylePoint) {
		this.stylePoint = stylePoint;
	}

	@Column(nullable=true)
	public Integer getCodePoint() {
		return codePoint;
	}

	public void setCodePoint(Integer codePoint) {
		this.codePoint = codePoint;
	}

	@Column(nullable=true)
	public Integer getAutoDocPoint() {
		return autoDocPoint;
	}

	public void setAutoDocPoint(Integer autoDocPoint) {
		this.autoDocPoint = autoDocPoint;
	}

	@Column(nullable=true)
	public Integer getManualDocPoint() {
		return manualDocPoint;
	}

	public void setManualDocPoint(Integer manualDocPoint) {
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

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	public Set<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(Set<TestCase> testCases) {
		this.testCases = testCases;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
}
