package com.practicehibernateexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Employee;

public class CreateExampleDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating a new employee object...");
			Employee employee1 = new Employee("Adam", "Ken", "Luv2code");
			Employee employee2 = new Employee("Drake", "Wolowitz", "Luv2code");
			Employee employee3 = new Employee("Shakira", "Bla Bla", "Luv2code");
			Employee employee4 = new Employee("Bamboozled", "Cooper", "Luv2code");
			

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the employee.....");
			
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}

		finally {
			factory.close();
		}

	}

}
