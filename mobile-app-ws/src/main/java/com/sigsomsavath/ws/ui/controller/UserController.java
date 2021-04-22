package com.sigsomsavath.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	@GetMapping
	public String getUser(@RequestParam(value="page") int page,
			@RequestParam(value= "limit", defaultValue = "50" ) int limit,
			@RequestParam(value= "sort", defaultValue = "desc", required = false ) String sort)
	{
		return "get users was called with page = " + page + " and limit " + limit + " at page " + page;
	}
	
	
	@GetMapping(path="/{userID}")
	public String getUser(@PathVariable String userID)
	{
		return "get user was called with userID" + userID;
	}
	
	@PostMapping
	public String createUser()
	{
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser() 
	{
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() 
	{
		return "Delete user was called";
	}

}
