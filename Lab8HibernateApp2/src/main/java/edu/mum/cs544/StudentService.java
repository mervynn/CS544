package edu.mum.cs544;

import javax.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		em.getTransaction().begin();
		Student student = studentdao.load(studentid);
		em.getTransaction().commit();
//		em.getTransaction().begin();
//		student.setFirstname("123123");
//		em.persist(student);
//		em.getTransaction().commit();
		System.out.println(em.contains(student));
		em.close();
		// closed error
//		System.out.println(em.contains(student));
		return student;
	}
}
