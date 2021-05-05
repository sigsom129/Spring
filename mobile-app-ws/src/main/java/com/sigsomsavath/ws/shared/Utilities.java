package com.sigsomsavath.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utilities {
	public String generateUserID() {
		return UUID.randomUUID().toString();
	}
}
