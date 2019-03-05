package com.cts.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.cts.bean.UserCred;

public class MainCRUD {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// UserCred user = new UserCred();
		// user.setId(2);
		// user.setUserName("ayyappa");
		// session.save(user);
		// t.commit();
		// System.out.println("Added 1 Record Successfully");
		// String hql = "SELECT u FROM UserCred u";
		// Query query = session.createQuery(hql);
		// List<UserCred> userList = query.getResultList();

		List<UserCred> userList = new ArrayList<UserCred>();
		userList = session.createNamedQuery("UserCred.findAll", UserCred.class).getResultList();

		for (UserCred userCred : userList) {
			System.out.println(userCred.getId() + " " + userCred.getUserName());
		}
		t.commit();

		factory.close();
		session.close();
	}
}
