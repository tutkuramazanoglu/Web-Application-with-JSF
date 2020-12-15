package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.project.model.Account;

/**
 * Bank Account class / connection
 * @author Poliana, Anjali, Tutku, Mounica
 *
 */
public class BankAccountDao {
	
	public Connection getConnection() {
		//Database info connection
		String url = "jdbc:mysql://localhost:3306/BankAccount";
		String user = "root";
		String pwd = "tutkuutku";
		Connection con = null ;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connection Successful!!!");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public List<Account> showAll(){

		String q = "Select * from Accounts";
		Connection con = getConnection();

		List<Account> list = new ArrayList<Account>();

		try {
			
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(q);

			while(rs.next()) {
				Account emp = new Account(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getDouble(5),
						rs.getString(6));
				
				list.add(emp);
			}
			System.out.println(list);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

public Account getRecById(int id) {
		
		Connection con = getConnection();		
		String sql = "select * from accounts where account_id = ?";		
		Account account = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(account);
		return account;	
	}
	
	public int updateById(int old_Id, Account updated_Acc) {
		
		
		Connection con = getConnection();
		
		
		
		String sql = "update accounts set account_id = ?, "
				+ "type = ?, holder_name = ?, holder_contact  =?, balance = ?, setup_date = ? where account_id=?";
		
		int status = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, updated_Acc.getAccount_id());
			
			pstmt.setString(2, updated_Acc.getType());
			
			pstmt.setString(3, updated_Acc.getHolder_name());
			
			pstmt.setString(4, updated_Acc.getHolder_contact());
			
			pstmt.setDouble(5, updated_Acc.getBalance());
			
			pstmt.setString(6, updated_Acc.getSetup_date());
			
			pstmt.setInt(7, old_Id);
			
			status = pstmt.executeUpdate();
			
			if(status>0)
			{
				
				System.out.println("Updated..!");
				
			}
			else
			{
				System.out.println("Try Again..!!");
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
	}
	
public int deleteRecById(int id){
		
		Connection con = getConnection();
		
		String sql = "delete from accounts where account_id=?";
		
		int status = 0 ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			status = pstmt.executeUpdate();
			
			if(status>0){
				
				System.out.println("deleted");
			}
			else {
				
				System.out.println("Try Again Please!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;		
		
	}

	public int addAccount(Account a) {
	Connection con=getConnection();
	int status=0;
	String sql="insert into accounts value (?,?,?,?,?,?)";
	try {
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setInt(1,a.getAccount_id());
		psmt.setString(2,a.getType());
		psmt.setString(3,a.getHolder_name());
		psmt.setString(4, a.getHolder_contact());
		psmt.setDouble(5, a.getBalance());
		psmt.setString(6, a.getSetup_date());
		status=psmt.executeUpdate();
		if(status>0) {
			System.out.print("Recoed insterted succesfully");
			showAll();
			}
		else {
			System.out.print("Recoed can not insterted");

		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return status;
	
}
}
