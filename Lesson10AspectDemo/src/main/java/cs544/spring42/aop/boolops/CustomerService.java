package cs544.spring42.aop.boolops;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	
	@Override
	public void doSomething() {
		System.out.println("something");
	}
	@Override
	public void otherThing() {
		System.out.println("other");
	}
	@Override
	public String getName() {
		return "John";
	}
	@Override
	public String getAge() {
		throw new MyException();
	}
}
