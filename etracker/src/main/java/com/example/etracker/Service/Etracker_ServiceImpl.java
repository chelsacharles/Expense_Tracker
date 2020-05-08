package com.example.etracker.Service;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.etracker.Dao.Etracker_Dao;

@Service
public class Etracker_ServiceImpl implements Etracker_Service{
	
	@Autowired
	Etracker_Dao epTrackDao;
	
	
	public Map<String, java.lang.Object> graph1(int uSER_ID){
		return epTrackDao.graph1(uSER_ID);
	}
	public Map<String, java.lang.Object> graph2(int uSER_ID){
		return epTrackDao.graph2(uSER_ID);
	}
	public Collection<Map<String,java.lang.Object>>  graph3(int uSER_ID){
		return epTrackDao.graph3(uSER_ID);
	}
	
	public Collection<Map<String,java.lang.Object>> graph4(int uSER_ID){
		return epTrackDao.graph4(uSER_ID);
	}
	
	public void addincome(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE) {
			epTrackDao.addincome(uSER_ID,iTEM,cATEGORY_ID,aMOUNT,tRANSACTION_DATE);
		
	}
	public void addexpense(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE) {
		epTrackDao.addexpense(uSER_ID,iTEM,cATEGORY_ID,aMOUNT,tRANSACTION_DATE);
	
	}

	public List<Map<String, Object>> monthlycategorysum(int uSER_ID) {
		return epTrackDao.monthlycategorysum(uSER_ID);
	}

	public List<Map<String, Object>> yearlycategorysum(int uSER_ID) {
		return epTrackDao.yearlycategorysum(uSER_ID);
	}
	
	public Collection<Map<String, Object>> getIncome(int uSER_ID) {
		return epTrackDao.getIncome(uSER_ID);
	}


	
	public Collection<Map<String, Object>> getExpense(int uSER_ID) {
		return epTrackDao.getExpense(uSER_ID);
	}


	public Collection<Map<String, Object>> getIncomeExpense(int uSER_ID) {
		return epTrackDao.getIncomeExpense(uSER_ID);
	}

	
}
