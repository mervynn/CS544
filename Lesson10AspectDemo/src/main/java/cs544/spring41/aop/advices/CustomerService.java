package cs544.spring41.aop.advices;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    /* (non-Javadoc)
     * @see cs544.spring41.aop.advices.ICustomerService#getName()
     */
    @Override
    public String getName() {
        return "John";
    }

    /* (non-Javadoc)
     * @see cs544.spring41.aop.advices.ICustomerService#getAge()
     */
    @Override
    public String getAge() {
        throw new MyException();
    }
}
