package com.example.etracker.Controller;



import java.util.Collection;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.etracker.Model.User;
import com.example.etracker.Service.Etracker_Service;


@RestController
@RequestMapping(value = "/tracker/register")
public class Etracker_Controller {
	
	@Autowired
	private Etracker_Service exp;
	
	@GetMapping("/TotalExpenseTotalIncomeBar_year")
	public Map<String, java.lang.Object> graph1(@RequestParam int uSER_ID ){
		return exp.graph1(uSER_ID);
	}
	
	@GetMapping("/TotalExpenseTotalIncomeBar_month")
	public Map<String, java.lang.Object> graph2(@RequestParam int uSER_ID ){
		return exp.graph2(uSER_ID);
	}
	@GetMapping("/TotalExpenseTotalIncomeLine_year")
	public Collection<Map<String,java.lang.Object>>  graph3(@RequestParam int uSER_ID ){
		return exp.graph3(uSER_ID);
	}
	@GetMapping("/TotalExpenseTotalIncomeLine_month")
	public Collection<Map<String,java.lang.Object>> graph4(@RequestParam int uSER_ID ){
		return exp.graph4(uSER_ID);
	}


	
	@PostMapping(path = "/addincome")
	 public void addincome(@RequestParam int USER_ID,@RequestParam String ITEM,@RequestParam int CATEGORY_ID,@RequestParam double AMOUNT,@RequestParam String TRANSACTION_DATE ) {
	 exp.addincome(USER_ID,ITEM,CATEGORY_ID,AMOUNT,TRANSACTION_DATE);
	 }
	@PostMapping(path = "/addexpense")
	 public void addexpense(@RequestParam int USER_ID,@RequestParam String ITEM,@RequestParam int CATEGORY_ID,@RequestParam double AMOUNT,@RequestParam String TRANSACTION_DATE ) {
	 exp.addexpense(USER_ID,ITEM,CATEGORY_ID,AMOUNT,TRANSACTION_DATE);
	 }
	
	@GetMapping(path = "/liscategoryexpense")
	public List<Map<String, Object>> liscategoryexpense()
	{
		return exp.liscategoryexpense();
	}
	@GetMapping(path = "/liscategoryincome")
	public List<Map<String, Object>> liscategoryincome()
	{
		return exp.liscategoryincome();
	}
	@GetMapping(path = "/monthlycategorysum")
	public List<Map<String, Object>> monthlycategorysum(@RequestParam int uSER_ID)
	{
		return exp.monthlycategorysum(uSER_ID);
	}
	@GetMapping(path = "/yearlycategorysum")
	public List<Map<String, Object>> yearlycategorysum(@RequestParam int uSER_ID)
	{
		return exp.yearlycategorysum(uSER_ID);
	}
	
	@GetMapping("/getIncome")
	public Collection<Map<String,Object>> getIncome(@RequestParam int uSER_ID){
		return exp.getIncome(uSER_ID);
	}
	

	@GetMapping("/getExpense")
	public Collection<Map<String,Object>> getExpense(@RequestParam int uSER_ID){
		return exp.getExpense(uSER_ID);
	}
	
	@GetMapping("/getIncomeExpense")
	public Collection<Map<String,Object>> getIncomeExpense(@RequestParam int uSER_ID){
		return exp.getIncomeExpense(uSER_ID);
	}

	@PostMapping
	public int addUser(@RequestBody User user ) {
		return exp.addUser(user);
		
		
	}
	@GetMapping(path="{EMAILID}/{PASSWORD}")
	public List<User> getUser(@PathVariable String EMAILID,@PathVariable String PASSWORD) {
		return exp.getUser(EMAILID,PASSWORD);
	}
	@PutMapping(path="{EMAILID}/{PASSWORD}")
	public int resetPassword(@PathVariable String EMAILID,@PathVariable String PASSWORD) {
		return exp.resetPassword(EMAILID,PASSWORD);
	}
	
	
}
