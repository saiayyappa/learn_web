package com.student.dao;

import java.util.List;

import com.student.model.StudentBean;

public interface StudentDao {

	public String insertStudent(StudentBean studentBean);
	
	public List<StudentBean> viewStudents();
	
	public int destroyStudent(int id);
}
