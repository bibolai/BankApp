package com.bibo.springmvc.bankapp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bibo.sprigmvc.bankapp.service.AccountService;
import com.bibo.springmvc.bankapp.model.Account;

@Controller
public class AccountController {

	private AccountService accountService;
	
	@Autowired
	@Qualifier("accountService")
	public void setAccountService(AccountService accountService_) {
		this.accountService = accountService_;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
		
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		
		return "index";
	}
	@RequestMapping("/new")
	public String newAccount(Model model) {
	    model.addAttribute("account", new Account());		
		return "account-form";
	}
	
	@RequestMapping("showAccount")
	public String showAccount() {
		return "showAccount";
	}
	
	@RequestMapping(value="/saveAccount", method=RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result ) 
	//    @RequestParam("accountNo") String acNo,
	  //  @RequestParam("accountHolderName") String customerName,
	    //@RequestParam("balance") String balance)
	{
	    //String acNo = request.getParameter("accountNo");
	    //String customerName = request.getParameter("accountHolderName");
	    //String balance = request.getParameter("balance");
	    /*model.addAttribute("accountNo1", acNo);
	    model.addAttribute("accountHolderName", customerName);
	    model.addAttribute("balance", balance);
		*/
	   // Account account = new Account();
	   // account.setAccountNo(Integer.valueOf(acNo));
	   // account.setAccountHolderName(customerName);
	   // account.setBalance(Integer.valueOf(balance));
	    
	   // model.addAttribute("account", account);
	    
		if(result.hasErrors()) {
			return "account-form";
			
		}
		else {
			System.out.println("what is sevice " + accountService);;
			accountService.saveAccount(account);
			return "redirect:/list";
		}
	}
}
