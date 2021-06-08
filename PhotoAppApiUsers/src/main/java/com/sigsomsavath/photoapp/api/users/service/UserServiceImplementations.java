package com.sigsomsavath.photoapp.api.users.service;



import java.util.UUID;

import com.sigsomsavath.photoapp.api.users.shared.UserDTO;

public class UserServiceImplementations implements UsersService {

	@Override
	public UserDTO createUser(UserDTO userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		return null;
	}

}
