package com.anurag.rupine.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.anurag.rupine.model.Login;
import com.anurag.rupine.model.Users;
import com.anurag.rupine.repository.UserRepository;

@Service
public class UserService {
	
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	UserRepository repository;
	
	public Users registerNewUserAccount(Users account) throws Exception {
	    if (emailExist(account.getEmail())) {
	    	System.out.println("inside exception");
	        throw new Exception(
	          "There is an account with that email adress:" + account.getEmail());
	    }
	    Users user = new Users();
	    user.setFirstName(account.getFirstName());
	    user.setLastName(account.getLastName());
	    user.setUsername(account.getUsername());
	    
	    user.setPassword(passwordEncoder.encode(account.getPassword()));
	    
	    user.setEmail(account.getEmail());
	    return repository.save(user);
	}
	
	public boolean emailExist(String emailId) {
		Users user=repository.findByEmail(emailId);
		if(user==null) {
			return false;
		}
		else {
			return true;
		}
	}
		
	public boolean login(Login login) {
		
		if(emailExist(login.getEmail())) {
		
			Users user=repository.findByEmail(login.getEmail());
			boolean isPasswordMatch = passwordEncoder.matches(login.getPassword(), user.getPassword());
			if(isPasswordMatch) {
				System.out.println("successfully login");
				return true;
			}
			else {
				System.out.println(user.getPassword());
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public Users getUser(String email) {
		return repository.findByEmail(email);
	}

}
