package com.sigsomsavath.ws.userservice;

import org.springframework.stereotype.Service;

import com.sigsomsavath.ws.ui.model.request.UserDetailsRequestModel;
import com.sigsomsavath.ws.ui.model.response.UserRest;

@Service
public interface UserService{
	UserRest createUser(UserDetailsRequestModel userDetails);
}