package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.model.StudentBean;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    
	@Autowired
	StudentDao studentDao;
	@Override
	public String insertStudent(StudentBean studentBean) {
		// TODO Auto-generated method stub
		return studentDao.insertStudent(studentBean);
	}
	@Override
	public List<StudentBean> viewStudents() {
		// TODO Auto-generated method stub
		return studentDao.viewStudents();
	}
	@Override
	public int destroyStudent(int id) {
		// TODO Auto-generated method stub
		return studentDao.destroyStudent(id);
	}
	
}
