package org.zeronight.spm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TestCase")
public class TestCase implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String content;
	private Set<Work> works;
	
	public TestCase(){
		
	}
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@ManyToMany(mappedBy = "testCases")
	public Set<Work> getWorks() {
		return works;
	}
	public void setWorks(Set<Work> works) {
		this.works = works;
	}
}
