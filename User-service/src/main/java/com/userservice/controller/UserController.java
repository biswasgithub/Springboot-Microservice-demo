package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.MobileEntity;
import com.userservice.entity.UserEntity;
import com.userservice.service.UserInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	UserInterface userService;

	@GetMapping("/userdetails")
	public ResponseEntity<UserEntity> getUserDetails() {
		UserEntity user = userService.getUserdetails();

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	// getForObject() return simple object.
	@GetMapping("/user")
	public ResponseEntity<UserEntity> getUserDetails1() {
		UserEntity user = userService.getUserdetails();

		String url = "http://MOBILE-SERVICE/mobile/get";
		MobileEntity mobile = restTemplate.getForObject(url, MobileEntity.class);
		System.out.println("***********************" + mobile.getName() + "   " + mobile.getId());

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@GetMapping("/usermobile")
	public ResponseEntity<UserEntity> getUserMobile() {
		UserEntity user = userService.gerUserMobile();

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}

	@GetMapping("/usermobilewithheader/{mobile}")
	public ResponseEntity<UserEntity> getUserMobileWithHeader(@RequestHeader(value = "usename") String userName,
			@RequestHeader(value = "password") String pass, @PathVariable String mobile) {
		UserEntity user = userService.gerUserMobile(mobile);

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}
	
	@PostMapping("/postusermobile/{mobile}")
	public ResponseEntity<UserEntity> postUserMobile(@PathVariable String mobile) {
		UserEntity user = userService.postUserMobile(mobile);

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}
	
	@PostMapping("/postusermobilewithheader/{mobile}")
	public ResponseEntity<UserEntity> postUserMobileWithHeader(@RequestHeader(value = "usename") String userName,
			@RequestHeader(value = "password") String pass, @PathVariable String mobile) {
		UserEntity user = userService.gerUserMobile(mobile);

		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}
}
