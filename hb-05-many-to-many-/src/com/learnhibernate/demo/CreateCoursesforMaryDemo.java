package com.learnhibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Course;
import com.learnhibernate.demo.entity.Instructor;
import com.learnhibernate.demo.entity.InstructorDetail;
import com.learnhibernate.demo.entity.Review;
import com.learnhibernate.demo.entity.Student;

public class CreateCoursesforMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
	
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// get the student Mary from the database
			int studentId =2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded student: " +tempStudent);
			System.out.println("Courses: " +tempStudent.getCourses());
			
			// create more courses
			Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("\nSaving the courses..........");
			
			session.save(tempCourse1);
			session.save(tempCourse2);
		
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
			
		}
		catch (Exception exc) {
            exc.printStackTrace();}
		
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
		
		

	}

}
