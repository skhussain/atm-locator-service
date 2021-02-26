package com.locatorService.models;

import java.util.List;

public class AtmListReponse extends ParentResponse{

	private List<ATMBean> atmList;

	public List<ATMBean> getAtmList() {
		return atmList;
	}

	public void setAtmList(List<ATMBean> atmList) {
		this.atmList = atmList;
	}
	
}
