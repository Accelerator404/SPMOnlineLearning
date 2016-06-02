package org.zeronight.spm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StudentGroup")
public class StudentGroup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int point;
	private int spm;
	private Set<Student> students;
	private Work work;
	public StudentGroup(){
		
	}
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(unique=true,length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getSpm() {
		return spm;
	}
	public void setSpm(int spm) {
		this.spm = spm;
	}
	@OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	@OneToOne(mappedBy = "studentGroup", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
	}
}
