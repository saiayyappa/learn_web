package com.student.service;

import java.util.List;

import com.student.model.StudentBean;

public interface StudentService {

	public String insertStudent(StudentBean studentBean);
	
	public List<StudentBean> viewStudents();

	public int destroyStudent(int id);
}
