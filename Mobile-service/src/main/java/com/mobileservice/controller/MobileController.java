package com.mobileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobileservice.entity.MobileEntity;
import com.mobileservice.entity.MobileResponse;
import com.mobileservice.service.MobileInterface;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	MobileInterface mobileService;
	
	@GetMapping("/allmobiles")
	public ResponseEntity<List<MobileEntity>> getAllMobile(){
		
		List<MobileEntity> listOfMobile=mobileService.getAllMobile();
		
		return new ResponseEntity<List<MobileEntity>>(listOfMobile,HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public MobileEntity getAllMobile3(){
		
		MobileEntity mobile=new MobileEntity("Redmi", "Redmi-111");
				
		
		return mobile;
		
	}
	
	
	@GetMapping("/getmobiles")
	public ResponseEntity<MobileResponse> getMobiles(){
		
		List<MobileEntity> listOfMobile=mobileService.getAllMobile();
		
		MobileResponse response=new MobileResponse(listOfMobile);
		return new ResponseEntity<MobileResponse>(response,HttpStatus.OK);
		
	}
	
	// for exchange()
	@GetMapping("/getmobileswithheader/{mobile}")
	public ResponseEntity<MobileResponse> getMobiles1(
			@RequestHeader(value="Username",required=true) String name,
    		@RequestHeader(value="Password",defaultValue = "rahul999") String pass,
    		@PathVariable String mobile){
		
		List<MobileEntity> listOfMobile=mobileService.getAllMobile(mobile);
		
		MobileResponse response=new MobileResponse(listOfMobile);
		return new ResponseEntity<MobileResponse>(response,HttpStatus.OK);
		
	}
	
	@PostMapping("/addmobile/{mobile}")
	public ResponseEntity<MobileResponse> addMobile(
    		@PathVariable String mobile){
		
		List<MobileEntity> listOfMobile=mobileService.getAllMobile(mobile);
		
		MobileResponse response=new MobileResponse(listOfMobile);
		return new ResponseEntity<MobileResponse>(response,HttpStatus.OK);
		
	}
}
