package org.zeronight.spm.teacher.service;

import java.util.List;

import org.zeronight.spm.model.Server;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.model.Work;

public interface ITeacherService {
	public Long getGroupAmount();
	public Long getStudentAmount();
	public Long getWorkAmount();
	public List<StudentGroup> getAllGroup();
	public List<Student> getStudentsByGroupId(int groupId);
	public StudentGroup getGroupById(int groupId);
	public boolean addGroup(StudentGroup group);
	public Student getStudentById(int studentId);
	public boolean deleteStudent(Student student);
	public List<Student> getStudentsWithNoGroup();
	public boolean updateStudent(Student student);
	public boolean addStudentToGroup(int groupId, int studentId);
	public List<Student> getAllStudents();
	public List<Server> getAllServer();
	public boolean addServer(Server server);
	public boolean delServer(Server server);
	public Server gerServerById(int serverId);
	public boolean updateServer(Server server);
	public List<Work> getAllWorks();
	public Work getWorkById(int workId);
	public boolean updateWork(Work work);
}
