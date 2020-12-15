package com.project.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * Account Class
 * @author Poliana, Anjali, Tutku, Mounica
 *
 */
@ManagedBean(name = "new_acc")
@RequestScoped
public class Account {
	
	private int account_id;
	private String type;
	private String holder_name;
	private String holder_contact;
	private double balance;
	private String setup_date;
	
	
	
	/**
	 * @param account_id
	 * @param type
	 * @param holder_name
	 * @param holder_contact
	 * @param balance
	 * @param setup_date
	 */
	public Account(int account_id, String type, String holder_name, String holder_contact, double balance,
			String setup_date) {
		super();
		this.account_id = account_id;
		this.type = type;
		this.holder_name = holder_name;
		this.holder_contact = holder_contact;
		this.balance = balance;
		this.setup_date = setup_date;
	}

	/**
	 * 
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * //Constructor public Account(int account_id, String type, String holder_name,
	 * String holder_contact, double balance, String setup_date) { super();
	 * this.account_id = account_id; this.type = type; this.holder_name =
	 * holder_name; this.holder_contact = holder_contact; this.balance = balance;
	 * this.setup_date = setup_date; }
	 */
	//Getter and setters
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHolder_name() {
		return holder_name;
	}

	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}

	public String getHolder_contact() {
		return holder_contact;
	}

	public void setHolder_contact(String holder_contact) {
		this.holder_contact = holder_contact;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getSetup_date() {
		return setup_date;
	}

	public void setSetup_date(String setup_date) {
		this.setup_date = setup_date;
	}

	//To string 
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", type=" + type + ", holder_name=" + holder_name
				+ ", holder_contact=" + holder_contact + ", balance=" + balance + ", setup_date=" + setup_date + "]";
	}
	
	
	
}
