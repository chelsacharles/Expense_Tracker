package com.example.etracker.Dao;


import java.sql.Types;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    private final String ADDINCOME = "INSERT INTO T_TRANSACTION(TRANSACTION_TYPE,USER_ID,ITEM,CATEGORY_ID,AMOUNT,TRANSACTION_DATE) VALUES (1,?,?,?,?,?)";
    private final String ADDEXPENSE = "INSERT INTO T_TRANSACTION(TRANSACTION_TYPE,USER_ID,ITEM,CATEGORY_ID,AMOUNT,TRANSACTION_DATE) VALUES (0,?,?,?,?,?)";
    private final String HME = "SELECT C.CATEGORY_NAME, SUM(AMOUNT) SUMAMOUNT FROM T_TRANSACTION T INNER JOIN T_CATEGORY C ON T.CATEGORY_ID = C.ID WHERE T.TRANSACTION_TYPE = 0 AND T.USER_ID = ? AND MONTH(T.TRANSACTION_DATE) = month(current_date() AND YEAR(T.TRANSACTION_DATE) = year(current_date()) GROUP BY C.CATEGORY_NAME"; 
    private final String HYE = "SELECT C.CATEGORY_NAME, SUM(AMOUNT) SUMAMOUNT FROM T_TRANSACTION T INNER JOIN T_CATEGORY C ON T.CATEGORY_ID = C.ID WHERE T.TRANSACTION_TYPE = 0 AND T.USER_ID = ? AND YEAR(T.TRANSACTION_DATE) = year(current_date()) GROUP BY C.CATEGORY_NAME"; 

    
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

	public void addincome(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE) {
		 Object[] incomearray = {uSER_ID,  iTEM,  cATEGORY_ID,  aMOUNT,tRANSACTION_DATE};
		 int[] incometype = {Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.DOUBLE,Types.DATE};
		 jdbcTemplate.update(ADDINCOME,incomearray,incometype);
		
	}
	public void addexpense(int uSER_ID, String iTEM, int cATEGORY_ID, double aMOUNT, String tRANSACTION_DATE) {
		 Object[] expensearray = {uSER_ID,  iTEM,  cATEGORY_ID,  aMOUNT,tRANSACTION_DATE};
		 int[] expensetype = {Types.BIGINT,Types.VARCHAR,Types.BIGINT,Types.DOUBLE,Types.DATE};
		 jdbcTemplate.update(ADDEXPENSE,expensearray,expensetype);
		
	}

	public List<Map<String, Object>> monthlycategorysum(int uSER_ID) {
		return jdbcTemplate.queryForList(HME,uSER_ID);

	}

	public List<Map<String, Object>> yearlycategorysum(int uSER_ID) {
		return jdbcTemplate.queryForList(HYE,uSER_ID);

	}
	

}
