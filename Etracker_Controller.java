package com.example.etracker.Controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/tracker")
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
	
	
	
	
}
