package com.learnhibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Instructor;
import com.learnhibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// get instructor by primary key / id
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " +tempInstructor);
			
			// delete the instructors
			if(tempInstructor!=null) {
				System.out.println("Deleting: " +tempInstructor);
				
				// Note : will also delete associated "details" object
				session.delete(tempInstructor);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		catch (Exception exc) {
            exc.printStackTrace();}
		
		finally {
			factory.close();
		}
		
		

	}

}
