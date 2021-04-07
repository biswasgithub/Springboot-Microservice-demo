package com.mobileservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mobileservice.entity.MobileEntity;

@Service
public class MobileService implements MobileInterface {

	@Override
	public List<MobileEntity> getAllMobile() {

		List<MobileEntity> listOfMobile = new ArrayList<MobileEntity>();

		MobileEntity mobile1 = new MobileEntity("Redmi", "Redmi-100");
		MobileEntity mobile2 = new MobileEntity("Samsung", "Samsung-100");

		listOfMobile.add(mobile1);
		listOfMobile.add(mobile2);

		return listOfMobile;
	}

	@Override
	public List<MobileEntity> getAllMobile(String mobile) {

		List<MobileEntity> listOfMobile = new ArrayList<MobileEntity>();

		MobileEntity mobile1 = new MobileEntity(mobile, mobile+"-100");

		listOfMobile.add(mobile1);

		return listOfMobile;
	}

}
