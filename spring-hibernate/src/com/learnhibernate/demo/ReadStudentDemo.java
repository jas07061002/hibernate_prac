package com.learnhibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			String theDateOfBirthStr = "11/11/1992";
	         Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			// create a student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com",theDateOfBirth);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student.....");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("Saved student. Generated id: " +tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on the id: primary key
			System.out.println("\nGetting student with id: "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class,tempStudent.getId());
			
			System.out.println("Get complete: " +myStudent);
			
			// commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			factory.close();
		}
		
		

	}

}
