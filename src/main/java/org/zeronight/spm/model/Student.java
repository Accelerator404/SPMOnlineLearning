package org.zeronight.spm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer point;
	private String mission;
	private Integer workTime;
	private User user;
	private StudentGroup studentGroup;

	public Student() {

	}

	@Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable=true)
	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	@Column(nullable=true)
	public Integer getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Integer workTime) {
		this.workTime = workTime;
	}

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
    @JoinColumn(name = "studentGroup_id")
	public StudentGroup getStudentGroup() {
		return studentGroup;
	}

	public void setStudentGroup(StudentGroup studentGroup) {
		this.studentGroup = studentGroup;
	}
}
