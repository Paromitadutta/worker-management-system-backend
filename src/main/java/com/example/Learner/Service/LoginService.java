package com.example.Learner.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Learner.Repo.LoginRepo;
import com.example.Learner.model.Login;

@Service
public class LoginService {
@Autowired
LoginRepo sr;
public Login addData(Login login)
{
	return sr.save(login);
}
public List <Login>getAllLogin()
{
	return sr.findAll();
}
//Get all Login By Id
public Login getLoginById(long id)
{
	return sr.findById(id).orElse(null);
}
public void deleteSecurity(Long id)
{
	sr.deleteById(id);
}
public Login UpdateLogin(Long userId, Login UpdateLogin) {
    Login existingLogin = sr.findById(userId)
        .orElseThrow(() -> new RuntimeException("Login not found with id " + userId));
    
    // Do NOT update userId
    existingLogin.setEmail(UpdateLogin.getEmail());
    existingLogin.setPassword(UpdateLogin.getPassword());
    
    return sr.save(existingLogin);
}

}
