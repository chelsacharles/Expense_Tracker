package com.example.etracker.Dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Etracker_Dao {
  
  public Map<String, java.lang.Object> graph1(int uSER_ID);
	public Map<String, java.lang.Object> graph2(int uSER_ID);
	public Collection<Map<String,java.lang.Object>>  graph3(int uSER_ID);
	public Collection<Map<String,java.lang.Object>> graph4(int uSER_ID);
	public void addincome(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE);
	public void addexpense(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE);
	public List<Map<String, Object>> monthlycategorysum(int uSER_ID);
	public List<Map<String, Object>> yearlycategorysum(int uSER_ID);



}
