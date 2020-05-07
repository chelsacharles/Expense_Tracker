package com.example.etracker.Dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class Etracker_DaoImpl implements Etracker_Dao {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    private final String G1 = "SELECT SUM(CASE WHEN transaction_type=0 THEN amount END) AS TotalExpense, SUM(CASE WHEN transaction_type=1 THEN amount END) AS TotalIncome FROM t_transaction WHERE year(transaction_date) = year( current_date()) and user_id= ? ";
    private final String G2 = "SELECT SUM(CASE WHEN transaction_type=0 THEN amount END) AS TotalExpense, SUM(CASE WHEN transaction_type=1 THEN amount END) AS TotalIncome FROM t_transaction WHERE year(transaction_date) = year( current_date()) and month(transaction_date) = month(current_date())and user_id=?";
    private final String G3 = "SELECT monthname(transaction_date) as Month, SUM(CASE WHEN transaction_type=0 THEN amount END) AS TotalExpense, SUM(CASE WHEN transaction_type=1 THEN amount END) AS TotalIncome FROM t_transaction WHERE year(transaction_date) = year(current_date()) and user_id=? group by Month";
    private final String G4 = "SELECT dayofmonth(transaction_date) as Day, SUM(CASE WHEN transaction_type=0 THEN amount END) AS TotalExpense, SUM(CASE WHEN transaction_type=1 THEN amount END) AS TotalIncome FROM t_transaction WHERE month(transaction_date) = month(current_date()) and year(transaction_date) = year(current_date()) and user_id=? group by Day";
    
	
    public Map<String, java.lang.Object> graph1(int uSER_ID) {
		
		return jdbcTemplate.queryForMap(G1,uSER_ID);
	}
    
	public Map<String, java.lang.Object> graph2(int uSER_ID) {
		
		return jdbcTemplate.queryForMap(G2,uSER_ID);
	}
	
    public Collection<Map<String,java.lang.Object>> graph3(int uSER_ID) {
		
		return jdbcTemplate.queryForList(G3,uSER_ID);
	}
    
    public Collection<Map<String,java.lang.Object>> graph4(int uSER_ID) {
		
		return jdbcTemplate.queryForList(G4,uSER_ID);
	}
 private final String FETCH_INCOME = "SELECT T_TRANSACTION.ITEM AS ITEM,T_TRANSACTION.AMOUNT AS AMOUNT, T_TRANSACTION.TRANSACTION_DATE AS DATE, T_CATEGORY.CATEGORY_NAME AS CATEGORY FROM T_TRANSACTION JOIN T_CATEGORY ON T_TRANSACTION.CATEGORY_ID=T_CATEGORY.ID WHERE T_TRANSACTION.TRANSACTION_TYPE=0 AND T_TRANSACTION.USER_ID= ? ORDER BY T_TRANSACTION.TRANSACTION_DATE DESC";
    private final String FETCH_EXPENSE = "SELECT T_TRANSACTION.ITEM AS ITEM,T_TRANSACTION.AMOUNT AS AMOUNT, T_TRANSACTION.TRANSACTION_DATE AS DATE, T_CATEGORY.CATEGORY_NAME AS CATEGORY FROM T_TRANSACTION JOIN T_CATEGORY ON T_TRANSACTION.CATEGORY_ID=T_CATEGORY.ID WHERE T_TRANSACTION.TRANSACTION_TYPE=1 AND T_TRANSACTION.USER_ID= ? ORDER BY T_TRANSACTION.TRANSACTION_DATE DESC";
    private final String FETCH_INCOME_EXPENSE = "SELECT T_TRANSACTION.ITEM AS ITEM,T_TRANSACTION.AMOUNT AS AMOUNT, T_TRANSACTION.TRANSACTION_DATE AS DATE, T_CATEGORY.CATEGORY_NAME AS CATEGORY FROM T_TRANSACTION JOIN T_CATEGORY ON T_TRANSACTION.CATEGORY_ID=T_CATEGORY.ID WHERE T_TRANSACTION.USER_ID= ? ORDER BY T_TRANSACTION.TRANSACTION_DATE DESC";
	

	public Collection<Map<String, Object>> getIncome(int uSER_ID) {
		return jdbcTemplate.queryForList(FETCH_INCOME, uSER_ID);
	}


	@Override
	public Collection<Map<String, Object>> getExpense(int uSER_ID) {
		return jdbcTemplate.queryForList(FETCH_EXPENSE, uSER_ID);
	}


	@Override
	public Collection<Map<String, Object>> getIncomeExpense(int uSER_ID) {
		return jdbcTemplate.queryForList(FETCH_INCOME_EXPENSE, uSER_ID);
	}



}
