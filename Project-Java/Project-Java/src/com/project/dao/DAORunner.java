package com.project.dao;

import com.project.model.Account;

/**
 * Class to tes connection
 * @author Poliana, Anjali, Tutku, Mounica
 *
 */
public class DAORunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccountDao b = new BankAccountDao();
		
//		b.getConnection();
		b.showAll();
//		b.deleteRecById(1);
//		b.showAll();
		
//		Account added_Acc = new Account(15, "S","Mariass","74384734", 5020.9,"2020-20-02");
//		
//		b.addAccount(added_Acc);
		}

}
