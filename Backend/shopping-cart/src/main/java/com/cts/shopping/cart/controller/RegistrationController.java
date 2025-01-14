package com.cts.shopping.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.shopping.cart.constants.Constants.ResponseStatus;
import com.cts.shopping.cart.model.UsersDetails;
import com.cts.shopping.cart.request.RegistrationRequest;
import com.cts.shopping.cart.response.RegistrationResponse;
import com.cts.shopping.cart.service.AuthService;

import javax.validation.Valid;

@RestController
public class RegistrationController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody @Valid RegistrationRequest req) throws Exception {

		UsersDetails usersDetails = new UsersDetails();
		usersDetails.setUsername(req.getUsername());
		usersDetails.setPassword(encoder.encode(req.getPassword()));

		usersDetails = authService.registerUser(usersDetails);
		System.out.println(usersDetails);

		return new ResponseEntity<Object>(new RegistrationResponse(req.getUsername(), ResponseStatus.Success),
				HttpStatus.OK);
	}

}
