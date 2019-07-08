package cs544.spring42.aop.boolops;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
	@Override
	public void createOrder(Customer customer, ShoppingCart shoppingCart) {
		System.out.println("Create Order");
	}
	@Override
	public void deleteOrder(String ordernumber) {
		System.out.println("Delete Order");
	}
	@Override
	public void shipOrder(String ordernumber) {
		System.out.println("Ship Order");
	}
}
