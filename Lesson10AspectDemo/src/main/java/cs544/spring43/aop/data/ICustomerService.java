package cs544.spring43.aop.data;

public interface ICustomerService {

	String getName();
	void setName(String name);

	int getAge();
	void setAge(int age);
	
	void exception();

}