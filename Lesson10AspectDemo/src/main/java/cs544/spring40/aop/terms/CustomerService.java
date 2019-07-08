package cs544.spring40.aop.terms;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	
	/* (non-Javadoc)
	 * @see cs544.spring40.aop.terms.ICustomerService#doSomething()
	 */
	@Override
	public void doSomething() {
		System.out.println("something");
	}
	/* (non-Javadoc)
	 * @see cs544.spring40.aop.terms.ICustomerService#otherThing()
	 */
	@Override
	public void otherThing() {
		System.out.println("other");
	}
}
