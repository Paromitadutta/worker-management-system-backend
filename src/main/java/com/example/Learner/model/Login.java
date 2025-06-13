package com.example.Learner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long UserId;
	public String Email;
	public String Password;
	
	Login()
	{
		
	}
	//getter and setter method
	public Login(Long userId,String email,String password )
	{
		super();
		this.UserId=userId;
		this.Email=email;
		this.Password=password;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
