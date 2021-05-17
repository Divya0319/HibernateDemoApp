package com.hibernatetutorial.practice_activity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.practice_activity.entity.Employee;
import com.hibernatetutorial.practice_activity.utils.DateUtils;

public class CreateEmployeePractice {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Employee.class)
										.buildSessionFactory();

				
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					String dateOfBirth = "09/12/1952";
					
					Date theDateOfBirth = DateUtils.parseDate(dateOfBirth);
					
					// create a student object
					System.out.println("Creating the Employee object...");
					Employee tempEmployee = new Employee("Sandman", "Baseplate", theDateOfBirth, "Captain");					
					
					// start the transaction
					session.beginTransaction();
					
					
					// save the student object
					System.out.println("Saving the employee...");
					session.save(tempEmployee);
					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				} catch(Exception exc) {
					
					exc.printStackTrace();
					
				}
				finally {
					factory.close();
				}

	}

}
