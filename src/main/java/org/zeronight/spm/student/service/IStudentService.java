package org.zeronight.spm.student.service;

import java.util.List;

import org.zeronight.spm.model.Server;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.User;
import org.zeronight.spm.model.Work;

public interface IStudentService {
	public User getUserByUsername(String username);
	public Work getWorkById(int workId);
	public Student getStudentById(int studentId);
	public List<Server> getAllServers();
	public boolean addWork(Work work);
	public boolean addOrUpdateWork(Work work);
}
