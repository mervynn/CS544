package cs544.spring43.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
	public Person byName(String name) {
		return new Person(name, 25);
	}
}
