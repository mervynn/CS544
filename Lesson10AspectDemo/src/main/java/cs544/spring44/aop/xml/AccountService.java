package cs544.spring44.aop.xml;

import java.util.ArrayList;
import java.util.Collection;

public class AccountService implements IAccountService {
	private Collection<Account> accountList = new ArrayList<>();

	@Override
	public void addAccount(int accountNumber, Customer customer) {
		Account account = new Account(accountNumber, customer);
		accountList.add(account);
		System.out.println("in execution of method addAccount");
	}
}