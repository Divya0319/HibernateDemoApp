package com.hibernatetutorial.practice_activity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.practice_activity.entity.Employee;

public class QueryEmployeePractice2 {

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
										
					List<Employee> employees = session.createQuery("from Employee e "
							+ "where e.company='Acting'").getResultList();
					
					System.out.println("Employees fetched with company = Acting");
					
					for(Employee emp : employees) {
						System.out.println(emp);
					}
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}

	}

}
