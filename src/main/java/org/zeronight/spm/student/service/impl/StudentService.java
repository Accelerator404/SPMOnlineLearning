package org.zeronight.spm.student.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeronight.spm.dao.IBaseDao;
import org.zeronight.spm.model.Server;
import org.zeronight.spm.model.Student;
import org.zeronight.spm.model.User;
import org.zeronight.spm.model.Work;
import org.zeronight.spm.student.service.IStudentService;

@Service("studentService")
@Transactional
public class StudentService implements IStudentService {
	@Autowired
	private IBaseDao<User> userDao;
	
	@Autowired
	private IBaseDao<Student> studentDao;
	
	@Autowired
	private IBaseDao<Work> workDao;
	
	@Autowired
	private IBaseDao<Server> serverDao;

	@Override
	public User getUserByUsername(String username) {
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		return userDao.get("from User where username=?", params);
	}

	@Override
	public Work getWorkById(int workId) {
		return workDao.get(Work.class, workId);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.get(Student.class, studentId);
	}

	@Override
	public List<Server> getAllServers() {
		return serverDao.find("from Server");
	}

	@Override
	public boolean addWork(Work work) {
		workDao.save(work);
		return true;
	}

	@Override
	public boolean addOrUpdateWork(Work work) {
		workDao.saveOrUpdate(work);
		return true;
	}

}

