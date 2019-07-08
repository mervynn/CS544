package cs544.spring42.aop.boolops;

public interface IOrderService {

	void createOrder(Customer customer, ShoppingCart shoppingCart);

	void deleteOrder(String ordernumber);

	void shipOrder(String ordernumber);

}