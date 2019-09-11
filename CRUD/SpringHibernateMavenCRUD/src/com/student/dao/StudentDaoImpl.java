package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.student.entity.StudentEntity;
import com.student.model.StudentBean;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Override
	public String insertStudent(StudentBean studentBean) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = null;
		Session session = null;
		String id = null;

		StringBuilder builder = new StringBuilder();

		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setName(studentBean.getName());
			studentEntity.setCollege(studentBean.getCollege());

			session.save(studentEntity);
			transaction.commit();

			studentEntity = session.get(StudentEntity.class, studentEntity.getId());
			builder.append("STUDENT ");
			builder.append(Long.toString(studentEntity.getId()));
			id = builder.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
	}

	@Override
	public List<StudentBean> viewStudents() {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = null;
		Session session = null;
		List<StudentBean> studDetails = null;

		StringBuilder builder = new StringBuilder();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			List list = session.createQuery("from StudentEntity").list();
			studDetails = new ArrayList();

			for (int i = 0; i < list.size(); i++) {
				StudentBean s= new StudentBean();
				StudentEntity studentEntity = (StudentEntity) list.get(i);
				s.setId(studentEntity.getId());
				s.setName(studentEntity.getName());
				s.setCollege(studentEntity.getCollege());			
		
				studDetails.add(s);
				
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return studDetails;
	}

	@Override
	public int destroyStudent(int id) {
		// TODO Auto-generated method stub
		SessionFactory sessionfactory = null;
		Session session = null;
		// String id = null;

		// StringBuilder builder = new StringBuilder();
		try {
			sessionfactory = HibernateUtil.getSessionFactory();
			session = sessionfactory.openSession();
			Transaction transaction = session.beginTransaction();
			StudentEntity studentEntity = new StudentEntity();

			studentEntity.setId(id);

			session.delete(studentEntity);
			transaction.commit();

			// studentEntity = session.get(StudentEntity.class,
			// studentEntity.getId());
			// builder.append("STUDENT ");
			// builder.append(Long.toString(studentEntity.getId()));
			// id = builder.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 1;
	}
}
