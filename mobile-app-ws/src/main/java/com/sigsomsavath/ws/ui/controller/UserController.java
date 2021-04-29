package com.sigsomsavath.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sigsomsavath.ws.exceptions.UserServiceExceptions;
import com.sigsomsavath.ws.ui.model.request.UpdateUsersDetailsRequestModel;
import com.sigsomsavath.ws.ui.model.request.UserDetailsRequestModel;
import com.sigsomsavath.ws.ui.model.response.UserRest;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {

	Map<String, UserRest> users;

	@GetMapping
	public String getUser(@RequestParam(value = "page") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get users was called with page = " + page + " and limit " + limit + " at page " + page;
	}

	@GetMapping(path = "/{userID}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
//		String firstname = null;
		if(true) throw new UserServiceExceptions("A user service exception is thrown");
		
		if (users.containsKey(userID)) {
			return new ResponseEntity<>(users.get(userID), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstname(userDetails.getFirstname());
		returnValue.setLastname(userDetails.getLastname());

		String userID = UUID.randomUUID().toString();
		returnValue.setUserId(userID);
		if (users == null)
			users = new HashMap<>();
		users.put(userID, returnValue);

		return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
	}

	@PutMapping(path="/{userID}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userID, @Valid @RequestBody UpdateUsersDetailsRequestModel userDetails) {
		
		UserRest storedUserDetails = users.get(userID);
		storedUserDetails.setFirstname(userDetails.getFirstname());
		storedUserDetails.setLastname(userDetails.getLastname());
		
		return storedUserDetails;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}

}
