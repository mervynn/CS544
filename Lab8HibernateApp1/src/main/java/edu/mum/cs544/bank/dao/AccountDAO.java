package edu.mum.cs544.bank.dao;

import edu.mum.cs544.bank.EntityManagerHelper;
import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountDAO implements IAccountDAO {
//    Collection<Account> accountlist = new ArrayList<Account>();

    public void saveAccount(Account account) {
        // System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
//        accountlist.add(account); // add the new
    }

    public void updateAccount(Account account) {
        // System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
//        Account accountexist = loadAccount(account.getAccountnumber());
//        if (accountexist != null) {
//            accountlist.remove(accountexist); // remove the old
//            accountlist.add(account); // add the new
//        }
        EntityManager em = EntityManagerHelper.getCurrent();
        em.merge(account);
    }

    public Account loadAccount(long accountnumber) {
        // System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
//        for (Account account : accountlist) {
//            if (account.getAccountnumber() == accountnumber) {
//                return account;
//            }
//        }
        EntityManager em = EntityManagerHelper.getCurrent();
        EntityGraph<Account> graph = em.createEntityGraph(Account.class);
        graph.addAttributeNodes("customer");
        graph.addAttributeNodes("entryList");
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("javax.persistence.fetchgraph", graph);
        return em.find(Account.class, accountnumber, properties);
    }

    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.createQuery("select distinct a from Account a join fetch a.entryList",
                Account.class).getResultList();
    }

}
