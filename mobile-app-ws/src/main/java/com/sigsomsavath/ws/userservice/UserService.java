package com.sigsomsavath.ws.userservice;

import com.sigsomsavath.ws.ui.model.request.UserDetailsRequestModel;
import com.sigsomsavath.ws.ui.model.response.UserRest;

public interface UserService{
	UserRest createUser(UserDetailsRequestModel userDetails);
}