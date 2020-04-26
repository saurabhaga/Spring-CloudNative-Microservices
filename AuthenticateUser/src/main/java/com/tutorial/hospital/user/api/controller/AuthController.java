package com.tutorial.hospital.user.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.hospital.user.api.entity.Login;
import com.tutorial.hospital.user.api.entity.LoginResponse;
import com.tutorial.hospital.user.api.jpa.repositories.LoginRepository;
import com.tutorial.hospital.user.api.util.TokenUtil;

@RestController
public class AuthController {

	private LoginRepository loginRepo;
	private TokenUtil tokenUtil;
	
	public AuthController(@Autowired LoginRepository loginRepo , @Autowired TokenUtil tokenutil) {
		this.loginRepo = loginRepo;
		this.tokenUtil = tokenutil;
		
	}

	// validate user name passsword controller
	@PostMapping("/authenticate")
	public ResponseEntity<LoginResponse> authenticate(HttpServletRequest request) {

		boolean authenticated = false;
		String username = request.getHeader("username");
		String password = request.getHeader("password");

		boolean inputsValid = !StringUtils.isEmpty(username) && !StringUtils.isEmpty(password);
		if (inputsValid) {
			Login login = loginRepo.findByUsernameAndPassword(username, password);
			if (login != null) {
				authenticated = true;
			}
		}

		if (authenticated) {
			// get jwt 
			String token = tokenUtil.generateToken(username);
			LoginResponse response = new LoginResponse("success", "Authenticated");
			return ResponseEntity.ok().header("token", token).body(response);
		} else {
			LoginResponse response = new LoginResponse("failure", " Not Authenticated");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}

	}
}
