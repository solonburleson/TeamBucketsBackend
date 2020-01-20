package com.buckets.bankingapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buckets.bankingapp.models.User;
import com.buckets.bankingapp.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
    	return userService.createUser(user);
    }
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id")Long id) {
		return userService.getUser(id);
	}
	
}
