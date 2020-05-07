package com.example.etracker.Service;


import org.springframework.stereotype.Service;

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

	public Collection<Map<String, Object>> getIncome(int uSER_ID) {
		return epTrackDao.getIncome(uSER_ID);
	}


	@Override
	public Collection<Map<String, Object>> getExpense(int uSER_ID) {
		return epTrackDao.getExpense(uSER_ID);
	}


	@Override
	public Collection<Map<String, Object>> getIncomeExpense(int uSER_ID) {
		return epTrackDao.getIncomeExpense(uSER_ID);
	}

	
}
