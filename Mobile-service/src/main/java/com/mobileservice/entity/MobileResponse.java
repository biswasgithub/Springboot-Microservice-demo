package com.mobileservice.entity;

import java.util.List;

public class MobileResponse {

	private List<MobileEntity> listOfMobile;

	
	
	public MobileResponse() {
		super();
	}

	public MobileResponse(List<MobileEntity> listOfMobile) {
		super();
		this.listOfMobile = listOfMobile;
	}

	public List<MobileEntity> getListOfMobile() {
		return listOfMobile;
	}

	public void setListOfMobile(List<MobileEntity> listOfMobile) {
		this.listOfMobile = listOfMobile;
	}
	
	
}
