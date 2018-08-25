package com.bibo.springmvc.bankapp.model;


import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bibo.springmvc.bankapp.validations.PSCode;

public class Account {

	@NotNull(message="Account# cant be blank")
	private Integer accountNo;
	
	@NotNull(message="account holder name cant be blank")
	@Size(min=2, max=10)
	@Pattern(regexp="[A-Za-z(\\s)]+",message="Invalid account name")
	private String accountHolderName;
	
	@NotNull(message="balance is required")
	@Min(value=5000, message="balance has to be more than 5000")
	private Integer balance;
	
	@NotNull(message="Account type cant be null")
	private String accountType;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull(message="date of birthday cant be blank")
    private Date dateOfBirth;
	
	@NotNull(message="ps code is required")
	@PSCode
    private String psCode;
    
	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}


    public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}
	
	public Account() {
		accountNo = null;
		accountHolderName = null;
		balance = null;	
		accountType=null;
		dateOfBirth = new Date();
		psCode =null;
	}
	
	public Account(Integer accNo, String holderName, Integer balance, String accountType, String psCode, Date dob) {
		this.accountNo = accNo;
		this.accountHolderName = holderName;
		this.balance = balance;
		this.accountType = accountType;
		this.psCode = psCode;
		this.dateOfBirth = dob;
		
	}
}
