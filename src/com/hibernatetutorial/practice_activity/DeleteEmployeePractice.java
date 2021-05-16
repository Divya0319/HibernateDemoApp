package com.hibernatetutorial.practice_activity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.practice_activity.entity.Employee;

public class DeleteEmployeePractice {
	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();

				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					
					session.beginTransaction();
					long empId = 3;
					
					System.out.println("Getting employee with id = " + empId);
					Employee tempEmp = session.get(Employee.class, empId);
					
					System.out.println("\nDeleting employee: " + tempEmp);
					
					session.createQuery("delete from Employee where id = "+ empId).executeUpdate();
					
					session.getTransaction().commit();
					
					System.out.println("Done!!");
					
				} finally {
					factory.close();
				}
	}

}
