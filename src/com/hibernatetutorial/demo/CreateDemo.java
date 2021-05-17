package com.hibernatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatetutorial.demo.entity.Instructor;
import com.hibernatetutorial.demo.entity.InstructorDetail;
import com.hibernatetutorial.demo.entity.Student;

public class CreateDemo {

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
			
			// create the objects
			Instructor tempInstructor = 
					new Instructor("Chad", "Darby", "darby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://luv2code.com/youtube",
							"Luv 2 code");
			
			
			
			
			// create the objects
			/*Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
						
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
							"http://www.youtube.com",
							"Guitar");
			*/
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			// start the transaction
			session.beginTransaction();
			
			session.save(tempInstructor);
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("------------       -----------------");
			System.out.println("Done!!");
			System.out.println("------------       -----------------");
			
		}
		finally {
			factory.close();
		}
	}

}
