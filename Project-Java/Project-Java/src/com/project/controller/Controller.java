package com.project.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.project.dao.BankAccountDao;
import com.project.model.Account;

@ManagedBean(name="con")
@SessionScoped
public class Controller {

	BankAccountDao obj = new BankAccountDao();
	
	int old_Id = 0;
	
	public List<Account> showAllRecords(){
		
		List<Account> account = obj.showAll();
		return account;
			
	}
	
	public String edit(int id) {
		
		old_Id = id;
		
		Account account = obj.getRecById(id);
		
		//employee object coming from DB
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		sessionMap.put("account", account);
		
		System.out.println(account);
		
		return "edit";
		
		
	}

	public String update(Account updated_Acc) {
		
		obj.updateById(old_Id, updated_Acc);
		
		return "index";
		
	}
	
	public String delete(int id){
		
		obj.deleteRecById(id);
		
		return "index" ;
		
	}
	
	public String insert() {
		
		return "insert";
	}
	
	public String insertAccount(Account added_account) {
		obj.addAccount(added_account);
		return "index";
	}
	
}
