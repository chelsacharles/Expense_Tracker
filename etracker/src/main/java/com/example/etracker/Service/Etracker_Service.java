package com.example.etracker.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.etracker.Model.User;

public interface Etracker_Service {
	
    public Map<String, java.lang.Object> graph1(int uSER_ID);
	public Map<String, java.lang.Object> graph2(int uSER_ID);
	public Collection<Map<String,java.lang.Object>>  graph3(int uSER_ID);
	public Collection<Map<String,java.lang.Object>> graph4(int uSER_ID);
	public void addincome(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE);
	public void addexpense(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE);
	public List<Map<String, Object>> monthlycategorysum(int uSER_ID);
	public List<Map<String, Object>> yearlycategorysum(int uSER_ID);

	public Collection<Map<String,Object>>  getIncome(int uSER_ID);

	public Collection<Map<String, Object>> getExpense(int uSER_ID);

	public Collection<Map<String, Object>> getIncomeExpense(int uSER_ID);
	
	public List<User> getUser(String EMAILID, String PASSWORD);
	public int resetPassword(String EMAILID, String PASSWORD);

	public int addUser(long l, String Name, String Email_Id, String Password );
	
	public List<Map<String, Object>> liscategoryexpense();
	public List<Map<String, Object>> liscategoryincome();
	
}
