package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.student.model.StudentBean;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/addStudent")
	public String addStudent(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String college = request.getParameter("college");
		String id = null;
		StudentBean studentBean = new StudentBean();
		studentBean.setName(name);
		studentBean.setCollege(college);

		id = studentService.insertStudent(studentBean);

		if (id != null) {
			return "addSuccess";
		} else {
			return "Error";
		}
	}

	@RequestMapping("/fetchStudents")
	public String fetchStudents(HttpServletRequest request, HttpSession session) {
		List<StudentBean> studList = new ArrayList<StudentBean>();
		studList = studentService.viewStudents();
		if (studList != null) {
			request.setAttribute("studList", studList);
			return "viewStudents";
		} else
			return "Error";
	}
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam String id){
		int i = studentService.destroyStudent(Integer.parseInt(id));
		if(i != 0)
			return "index";
		else
			return "Error";
		
	}
	
}
