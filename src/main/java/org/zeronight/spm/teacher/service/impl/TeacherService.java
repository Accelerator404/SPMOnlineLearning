package org.zeronight.spm.teacher.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.Server;
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
	
	@Autowired
	private IBaseDao<Server> serverDao;

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
	public boolean addGroup(StudentGroup group) {
		groupDao.save(group);
		return true;
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.get(Student.class, studentId);
	}

	@Override
	public boolean deleteStudent(Student student) {
		studentDao.delete(student);
		return true;
	}

	@Override
	public List<Student> getStudentsWithNoGroup() {
		return studentDao.find("from Student s where s.studentGroup is null");
	}

	@Override
	public boolean updateStudent(Student student) {
		studentDao.update(student);
		return true;
	}

	@Override
	public boolean addStudentToGroup(int groupId, int studentId) {
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

	@Override
	public List<Server> getAllServer() {
		return serverDao.find("from Server");
	}

	@Override
	public boolean addServer(Server server) {
		serverDao.save(server);
		return true;
	}

	@Override
	public boolean delServer(Server server) {
		serverDao.delete(server);
		return true;
	}

	@Override
	public Server gerServerById(int serverId) {
		return serverDao.get(Server.class, serverId);
	}

	@Override
	public boolean updateServer(Server server) {
		serverDao.update(server);
		return true;
	}

	@Override
	public List<Work> getAllWorks() {
		return workDao.find("from Work");
	}

	@Override
	public Work getWorkById(int workId) {
		return workDao.get(Work.class, workId);
	}

	@Override
	public boolean updateWork(Work work) {
		workDao.update(work);
		return true;
	}

}
