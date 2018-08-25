package com.bibo.springmvc.bankapp.dao;

import org.springframework.stereotype.Repository;

import com.bibo.springmvc.bankapp.model.Account;

@Repository
public interface AccountDao {

	public boolean saveAccocunt(Account account);
}
