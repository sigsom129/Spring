package com.sigsomsavath.photoapp.api.users.service;



import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigsomsavath.photoapp.api.users.data.UserRepository;
import com.sigsomsavath.photoapp.api.users.data.UsersEntity;
import com.sigsomsavath.photoapp.api.users.shared.UserDTO;

@Service
public class UserServiceImplementations implements UsersService {
	UserRepository userRepository;
	
	@Autowired
	public UserServiceImplementations(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	@Override
	public UserDTO createUser(UserDTO userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UsersEntity userEntity = modelMapper.map(userDetails,UsersEntity.class);
		
		
		userEntity.setEncryptedPassword("Test");
		userRepository.save(userEntity);
		
		return null;
	}

}
