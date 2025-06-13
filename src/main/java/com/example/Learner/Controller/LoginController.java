package com.example.Learner.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Learner.Service.LoginService;
import com.example.Learner.model.Login;

@CrossOrigin(origins = "https://worker-management-system.vercel.app")
@RestController
@RequestMapping("api/login")
public class LoginController {

	private final LoginService ls;

	@Autowired
	public LoginController(LoginService ls) {
		this.ls = ls;
	}

	@PostMapping("/add")
	public Login addLogin(@RequestBody Login login) {
		return ls.addData(login);
	}

	// Get all Login
	@GetMapping
	public List<Login> getAllLogin() {
		return ls.getAllLogin();
	}

	// Get Login By Id
	@GetMapping("/{id}")
	public Login getLoginById(@PathVariable("id") Long id) {
		return ls.getLoginById(id);
	}

	// Delete Login By Id
	@DeleteMapping("/{id}")
	public void deleteSecurity(@PathVariable("id") Long id) {
		ls.deleteSecurity(id);
	}

	@PutMapping(("/{id}"))
	public Login UpdateLogin(@PathVariable Long id, @RequestBody Login UpdateLogin) {
		return ls.UpdateLogin(id, UpdateLogin);
	}
}
