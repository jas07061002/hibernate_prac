package com.practicehibernateexample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learnhibernate.demo.entity.Employee;

public class ReadExampleDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

// create a session
		Session session = factory.getCurrentSession();

		try {
			
			Employee e1 = new Employee("Jas","K","Luv2code");
			
			List<Employee> emp = session.createQuery("from Employee s ").getResultList();
// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Saving the employee.....");
			
			session.save(e1);

// retrieve the employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + e1.getId());

			Employee employee = session.get(Employee.class, e1.getId());

			System.out.println("Get complete: " + employee);

			// retrieve the employee based on the company
			emp = session.createQuery(" where "
					+ "s.company='Luv2code'")
					.getResultList();
			
			listofEmployees(emp);

			System.out.println("Get complete: " + employee);
			// commit the transaction

						session.getTransaction().commit();

						System.out.println("Done!");
		
			// delete the employee based on the id: primary key
			int employeeId =2;
			session = factory.getCurrentSession();
			session.beginTransaction();
						System.out.println("\nDeleting employee with id: " + employeeId);

					//	Employee employee5 = session.get(Employee.class, e1.getId());
					//	session = factory.getCurrentSession();
					//	session.beginTransaction();
						session.createQuery("Delete from Employee where id ="+employeeId).executeUpdate();	
						System.out.println("Get complete: " + employee);

						// commit the transaction
						session.getTransaction().commit();
						
						System.out.println("Done!");

		}

		finally {
			factory.close();
		}

	}

	private static void listofEmployees(List<Employee> emp) {
		for(Employee temp: emp) {
			System.out.println(temp);
			
		}
	}

}
