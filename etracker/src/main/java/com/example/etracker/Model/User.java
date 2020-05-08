package com.example.etracker.Model;

import java.math.BigInteger;

public class User {
	
	long Id;
	String Email_Id;
	String Name;
	String Password;
	public long getId() {
		return Id;
	}
	public void setId(long l) {
		Id = l;
	}
	public String getEmail_Id() {
		return Email_Id;
	}
	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
