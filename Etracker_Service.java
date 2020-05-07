package com.example.etracker.Service;

public interface Etracker_Service {
	
        public Map<String, java.lang.Object> graph1(int uSER_ID);
	public Map<String, java.lang.Object> graph2(int uSER_ID);
	public Collection<Map<String,java.lang.Object>>  graph3(int uSER_ID);
	public Collection<Map<String,java.lang.Object>> graph4(int uSER_ID);
	public Collection<Map<String,Object>>  getIncome(int uSER_ID);

	public Collection<Map<String, Object>> getExpense(int uSER_ID);

	public Collection<Map<String, Object>> getIncomeExpense(int uSER_ID);

	
}
