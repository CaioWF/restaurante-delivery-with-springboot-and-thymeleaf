package br.com.ufc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ufc.model.Role;
import br.com.ufc.model.User;
import br.com.ufc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) {
		user.setPass(new BCryptPasswordEncoder().encode(user.getPass()));
		
		Role role = new Role();
		role.setRole("ROLE_USER");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	public List<User> returnUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUser(Long code) {
		userRepository.deleteById(code);
	}
	
	public User getByCode(Long code) {
		return userRepository.getOne(code);
	}
	
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
