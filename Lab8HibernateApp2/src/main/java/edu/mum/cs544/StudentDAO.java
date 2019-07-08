package edu.mum.cs544;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {

	public Student load(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
//		System.out.println(em.createQuery("select s from Student s,Course c where c.grade = 'Java'", Student.class).getResultList());
//		em.close();
		em = EntityManagerHelper.getCurrent();
		EntityGraph<Student> graph = em.createEntityGraph(Student.class);
		graph.addAttributeNodes("courselist");
		Map<String, Object> properties = new HashMap<>();
		properties.put("javax.persistence.fetchgraph", graph);

		return em.find(Student.class, studentid, properties);
	}
}
