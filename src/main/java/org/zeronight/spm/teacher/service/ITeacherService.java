package org.zeronight.spm.teacher.service;

import java.util.List;

import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.StudentGroup;

public interface ITeacherService {
	public Long getGroupAmount();
	public Long getStudentAmount();
	public Long getWorkAmount();
	public List<StudentGroup> getAllGroup();
	public List<Student> getStudentsByGroupId(int groupId);
	public StudentGroup getGroupById(int groupId);
	public boolean AddGroup(StudentGroup group);
	public Student getStudentById(int studentId);
	public boolean DeleteStudent(Student student);
	public List<Student> getStudentsWithNoGroup();
	public boolean UpdateStudent(Student student);
	public boolean AddStudentToGroup(int groupId, int studentId);
	public List<Student> getAllStudents();
}
