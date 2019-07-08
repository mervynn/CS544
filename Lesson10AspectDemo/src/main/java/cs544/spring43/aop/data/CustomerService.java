package cs544.spring43.aop.data;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	private String name;
	private int age;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void exception() {
		throw new MyException();
	}

}
