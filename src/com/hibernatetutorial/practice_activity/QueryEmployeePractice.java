package com.hibernatetutorial.practice_activity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.practice_activity.entity.Employee;

public class QueryEmployeePractice {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();

				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					
					// start the transaction
					session.beginTransaction();
					
					long employeeId = 1;
					
					Employee tempEmployee = session.get(Employee.class, employeeId);
					
					System.out.println("Employee fetched with id:1" + tempEmployee);
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}

	}

}
