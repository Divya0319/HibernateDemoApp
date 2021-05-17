package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.demo.entity.Instructor;
import com.hibernatetutorial.demo.entity.InstructorDetail;
import com.hibernatetutorial.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start the transaction
			session.beginTransaction();
						
						
			// get the instructor detail object
			int theId = 98898;
			InstructorDetail tempInstructorDetail = 
					session.get(InstructorDetail.class, theId);
			
			// print the instructor detail
			System.out.println("--------   -----------------------");
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			System.out.println("--------   -----------------------");
			
			// print the associated instructor
			System.out.println("--------   -----------------------");
			System.out.println("the associated instructor: " 
					+ tempInstructorDetail.getInstructor());
			System.out.println("--------   -----------------------");
		
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} catch(Exception exc) {
			
			exc.printStackTrace();
			
		}
		finally {
			
			// close the connection
			session.close();
			factory.close();
		}
	}

}
