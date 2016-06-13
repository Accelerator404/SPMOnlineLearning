package org.zeronight.spm.teacher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.StudentGroup;
import org.zeronight.spm.model.Work;
import org.zeronight.spm.teacher.service.ITeacherService;

@Service("teacherService")
public class TeacherService implements ITeacherService {
	@Autowired
	private IBaseDao<StudentGroup> groupDao;
	
	@Autowired
	private IBaseDao<Student> studentDao;
	
	@Autowired
	private IBaseDao<Work> workDao;

	@Override
	public Long getGroupAmount() {
		return groupDao.count("select count(s) from StudentGroup s");
	}

	@Override
	public Long getStudentAmount() {
		return studentDao.count("select count(s) from Student s");
	}

	@Override
	public Long getWorkAmount() {
		return workDao.count("select count(w) from Work w");
	}

	@Override
	public List<StudentGroup> getAllGroup() {
		return groupDao.find("from StudentGroup");
	}

	@Override
	public List<Student> getStudentsByGroupId(int groupId) {
		List<Object> param = new ArrayList<Object>();
		param.add(this.getGroupById(groupId));
		return studentDao.find("from Student where studentGroup = ?", param);
	}

	@Override
	public StudentGroup getGroupById(int groupId) {
		return groupDao.get(StudentGroup.class, groupId);
	}

	@Override
	public boolean AddGroup(StudentGroup group) {
		groupDao.save(group);
		return true;
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.get(Student.class, studentId);
	}

	@Override
	public boolean DeleteStudent(Student student) {
		studentDao.delete(student);
		return true;
	}

	@Override
	public List<Student> getStudentsWithNoGroup() {
		return studentDao.find("from Student s where s.studentGroup is null");
	}

	@Override
	public boolean UpdateStudent(Student student) {
		studentDao.update(student);
		return true;
	}

	@Override
	public boolean AddStudentToGroup(int groupId, int studentId) {
		Student student = studentDao.get(Student.class, studentId);
		StudentGroup group = groupDao.get(StudentGroup.class, groupId);
		student.setStudentGroup(group);
		studentDao.update(student);
		return true;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.find("from Student");
	}

}
