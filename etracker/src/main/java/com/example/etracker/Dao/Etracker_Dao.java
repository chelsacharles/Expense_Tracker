package com.example.etracker.Dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.etracker.Model.User;

public interface Etracker_Dao {
  
  public Map<String, java.lang.Object> graph1(int year,int userId);
	public Map<String, java.lang.Object> graph2(int year,String month,int userId);
	public Collection<Map<String,java.lang.Object>>  graph3(int year,int userId);
	public Collection<Map<String,java.lang.Object>> graph4(String month,int year,int userId);
	public void addincome(int userId, String item, int categoryId, double amount, String transactionDate);
	public void addexpense(int userId, String item, int categoryId, double amount, String transactionDate);
	public void addincomecategory(String categoryName);
	public void addexpensecategory(String categoryName);
	public List<Map<String, Object>> monthlycategorysum(int userId,String month,int year);
	public List<Map<String, Object>> yearlycategorysum(int userId,int year);

	public Collection<Map<String,Object>> getIncome(int userId);

	public Collection<Map<String, Object>> getExpense(int userId);

	public Collection<Map<String, Object>> getIncomeExpense(int userId);
	
	List<User> selectUser(String emailId, String password);

	int resetPassword(String emailId, String password);
	int addUser(long id, String name, String emailId, String password );
	public List<Map<String, Object>> liscategoryexpense();
	public List<Map<String, Object>> liscategoryincome();


}
