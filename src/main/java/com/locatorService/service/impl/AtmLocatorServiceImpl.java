package com.locatorService.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.locatorService.client.ConsumeRestService;
import com.locatorService.models.ATMBean;
import com.locatorService.models.AtmListReponse;
import com.locatorService.service.AtmLocatorService;
@Service
public class AtmLocatorServiceImpl implements AtmLocatorService{
	private static final Logger LOGGER=LogManager.getLogger(AtmLocatorServiceImpl.class);
	private static final String NODATAFOUND="NO DATA FOUND";
	private static final String NORESPONSE="NO Response";
	@Autowired
	private ConsumeRestService service;
	@Autowired
	private Environment env;
	@Override
	public AtmListReponse getAtmList() {
		ResponseEntity<String> entityResponse =null;
		AtmListReponse response=new AtmListReponse();
		String url="";
		try {
			url=env.getRequiredProperty("Locate.url");
		}catch(IllegalStateException e) {
			LOGGER.error("Please configure the property value for the following Key locatorUrl");
		}
		Long startTime=System.currentTimeMillis();
		try{
			entityResponse= service.getforEntity(url, String.class);
		}finally {
			Long endTime=System.currentTimeMillis();
			LOGGER.debug("Time taken to call the external service "+(endTime-startTime));
		}
		
		String body = entityResponse.getBody();
		if(null == body) {
			response.setReturnCode("1");
			response.setStatusMessage(NORESPONSE);
			LOGGER.info("No Response returned form the service");
			return response;
		}
		body=body.substring(5);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ATMBean[] fromJson = gson.fromJson(body, ATMBean[].class);
		List<ATMBean> list = Arrays.stream(fromJson).collect(Collectors.toList());
		if(null == list || list.isEmpty()) {
			response.setReturnCode("1");
			response.setStatusMessage(NODATAFOUND);
			LOGGER.info("No ATMs returned form the service");
			return response;
		}
		response.setAtmList(list);
		return response;
	}
	@Override
	public AtmListReponse getAtmByCity(String city) {
		ResponseEntity<String> entityResponse =null;
		AtmListReponse response=new AtmListReponse();
		String url="";
		try {
			url=env.getRequiredProperty("Locate.url");
		}catch(IllegalStateException e) {
			LOGGER.error("Please configure the property value for the following Key locatorUrl");
		}
		Long startTime=System.currentTimeMillis();
		try{
			entityResponse= service.getforEntity(url, String.class);
		}finally {
			Long endTime=System.currentTimeMillis();
			LOGGER.debug("Time taken to call the external service "+(endTime-startTime));
		}
		String body = entityResponse.getBody();
		if(null == body) {
			response.setReturnCode("1");
			response.setStatusMessage(NORESPONSE);
			LOGGER.info("No Response returned form the service");
			return response;
		}
		body=body.substring(5);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ATMBean[] fromJson = gson.fromJson(body, ATMBean[].class);
		List<ATMBean> list = Arrays.stream(fromJson).filter(x->city.equals(x.getAddress().getCity())).collect(Collectors.toList());
		if(null == list || list.isEmpty()) {
			response.setReturnCode("1");
			response.setStatusMessage("No ATMS found in that city name "+city);
			LOGGER.info("No ATMs returned form the service");
			return response;
		}
		response.setAtmList(list);
		return response;
	}
	
}
