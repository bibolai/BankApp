package com.bibo.springmvc.bankapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bibo.springmvc.bankapp.entity.AccountEntity;
import com.bibo.springmvc.bankapp.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccocunt(Account account) {

		boolean saveFlag = true;
		AccountEntity ae = new AccountEntity();
		ae.setAccNo(account.getAccountNo());
		ae.setAccHolderName(account.getAccountHolderName());
		ae.setAccountType(account.getAccountType());
		ae.setBalance(account.getBalance());
		ae.setDateOfBirth(account.getDateOfBirth());
		ae.setPsCode(account.getPsCode());
		
		try {
			Session currentSession = sessionFactory.getCurrentSession();
		    currentSession.save(ae);
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			saveFlag = false;
			
		}
		return saveFlag;
		
	}

}
