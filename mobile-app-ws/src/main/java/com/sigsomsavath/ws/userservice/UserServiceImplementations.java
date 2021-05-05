package com.sigsomsavath.ws.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sigsomsavath.ws.ui.model.request.UserDetailsRequestModel;
import com.sigsomsavath.ws.ui.model.response.UserRest;

@Service
public class UserServiceImplementations implements UserService {

	Map<String, UserRest> users;

	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstname(userDetails.getFirstname());
		returnValue.setLastname(userDetails.getLastname());

		String userID = UUID.randomUUID().toString();
		returnValue.setUserId(userID);
		if (users == null)
			users = new HashMap<>();
		users.put(userID, returnValue);

		return returnValue;

	}

}
