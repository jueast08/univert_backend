package com.univert.dao;

public class UserDao {

}
/*
package customerDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class DbCustomerDao extends ACustomerDAao{

	@Override
	public String getCustomerID(String customerName) {
		String customerID = "-1";
		try {
			ResultSet PlatformCount = DbManagement.getInstance().query(MySQLManagement.getCustomerId(customerName));
	         
	        if(!PlatformCount.next()){
	            return customerID;
	        }
	        else{
	        	PlatformCount.beforeFirst();
	        }
	         
	        if(PlatformCount.first())
	        	customerID = PlatformCount.getString("id");
	        PlatformCount.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerID;
	}


	@Override
	public ArrayList<Alert> getAlertList(String ID) {
		ArrayList<Alert> alertList = new ArrayList<Alert>();
		
		try {
			ResultSet alert = DbManagement.getInstance().query(MySQLManagement.AlertListByID(ID));
			
			if(!alert.next()){
                return null;
            }
            else{
            	alert.beforeFirst();
            }
			
			while(alert.next()) {
				boolean isFlatAlert = false;
				if(Integer.parseInt(alert.getString("ISFLAT")) == 1) {
					isFlatAlert = true;
				}

				if(alert.getString("PLATFORM1") != null)
				{
					alertList.add(new Alert(Integer.parseInt(alert.getString("ID")), 
							alert.getString("CRYPTOPAIR"),
							alert.getString("PLATFORM1"),
							alert.getString("PLATFORM2"),
							alert.getString("TAUXVALUES"),
							isFlatAlert));
				}
				else {
					alertList.add(new Alert(Integer.parseInt(alert.getString("ID")),
							alert.getString("CRYPTOPAIR"),
							alert.getString("TAUXVALUES"),
							isFlatAlert));
				}
			
			}
			alert.close();
		}catch (SQLException e) {
            e.printStackTrace();
		}
		
		return alertList;
	}


	@Override
	public Customer getCustomerByName(String login) {
		return new Customer(getCustomerID(login), login, getAlertList(getCustomerID(login)));
	}


	@Override
	public String valideLogin(String Login, String Password) {
		String id = "-1";
		
		try {

			ResultSet loginData = DbManagement.getInstance().query(MySQLManagement.LoginPassword(Login));
			
			if(!loginData.next()){
                return "-2";
            }
            else{
            	loginData.beforeFirst();
            }
			while(loginData.next())
			{
			
				if(!Login.contentEquals(loginData.getString("Login"))){
					id = "-2";
				}
				if(Login.contentEquals(loginData.getString("Login")) && Password.contentEquals(loginData.getString("Password"))) {
					id = loginData.getString("ID");
				}
			}
			loginData.close();
		}catch (SQLException e) {
            e.printStackTrace();
		}
		return id;
	}


	@Override
	public int createCustomer(String Login, String Password) {
		int ret = -1;
		boolean isPresent = false;
		try {
			ResultSet loginData = DbManagement.getInstance().query(MySQLManagement.AllLogin());
			if(!loginData.next()){
                return ret;
            }
            else{
            	loginData.beforeFirst();
            }
			while(loginData.next()) {
				
				if(loginData.getString("LOGIN").contentEquals(Login))
				{
					isPresent = true;
				}
			
			}
			if(!isPresent) {
				
				ret = DbManagement.getInstance().insert(MySQLManagement.createCustomer(Login, Password));
			}
			loginData.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}


	@Override
	public int deleteCustomer(String Login) {
		int ret = -1;
		
		try {
			String id = getCustomerID(Login);
			ret = DbManagement.getInstance().insert(MySQLManagement.deleteCustomer(Login));
			DbManagement.getInstance().insert(MySQLManagement.deleteCustomerAlert(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}


	@Override
	public int createAlert(String Id, Alert alert) {
		int ret = -1;
		
		try {
			
			ret = DbManagement.getInstance().insert(MySQLManagement.createAlert(Id, alert));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	

}
*/