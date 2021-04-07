package com.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.entity.MobileResponse;
import com.userservice.entity.UserEntity;

@Service
public class UserService implements UserInterface {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserEntity getUserdetails() {

		UserEntity user = new UserEntity("Rahul", 101);
		return user;
	}

	// getForEntity() for response body and status-code
	public UserEntity gerUserMobile() {

		UserEntity user = new UserEntity("Rahul", 101);

		// call mobile service

		String url = "http://MOBILE-SERVICE/mobile/allmobiles/";
		ResponseEntity<MobileResponse> listOfMobile = restTemplate.getForEntity(url, MobileResponse.class);
		user.setUserMobiles(listOfMobile.getBody());

		return user;
	}

	// exchange() used for passing header and return response body and status-code
	@Override
	public UserEntity gerUserMobile(String mobile) {
		UserEntity user = new UserEntity("Rahul", 101);

		// call mobile service

		String url= "http://MOBILE-SERVICE/mobile/getmobileswithheader/"+mobile;
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("username", "true");  
		headers.set("password", "USA");
		
		HttpEntity<MobileResponse> requestEntity = new HttpEntity<>(null, headers);
		
		ResponseEntity<MobileResponse> listOfMobile = restTemplate.exchange(url,HttpMethod.GET, requestEntity, MobileResponse.class);
		user.setUserMobiles(listOfMobile.getBody());

		return user;
	}

	@Override
	public UserEntity postUserMobile(String mobile) {
		UserEntity user = new UserEntity("Rahul", 101);

		// call mobile service

		String url= "http://MOBILE-SERVICE/mobile/addmobile/"+mobile;
		ResponseEntity<MobileResponse> mobileResponse = restTemplate.postForEntity(url, HttpMethod.POST, MobileResponse.class);
		
		if(mobileResponse.getStatusCode()==HttpStatus.OK) {
			user.setUserMobiles(mobileResponse.getBody());
		}
		
		return user;
	}

}
