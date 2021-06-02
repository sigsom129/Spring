package com.sigsomsavath.photoapp.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.sigsomsavath.photoapp.api.user.ui.controller.UsersController;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiUsersApplication extends UsersController {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}

}
