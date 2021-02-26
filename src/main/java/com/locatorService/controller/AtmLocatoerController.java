package com.locatorService.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.locatorService.models.AtmListReponse;
import com.locatorService.service.AtmLocatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "ATM service controller ")
@RestController
public class AtmLocatoerController {
	private static final Logger LOGGER=LogManager.getLogger(AtmLocatoerController.class);
	
	
	
	@Autowired
	private AtmLocatorService locatorService;
	
	@ApiOperation(value="Get All list of ATMS from locator service")
	@GetMapping("/getAllAtms")
	public AtmListReponse getAtmList(){
		LOGGER.debug("Starting the ATM locater web service Call");
		AtmListReponse response = locatorService.getAtmList();
		LOGGER.debug("Ending the ATM locater web service Call");
		
		return response;
	}
	
	@ApiOperation(value="Get Atm from the mentioned City")
	@GetMapping("/getAtmByCity/city/{city}")
	public AtmListReponse getAtrmBycity(@PathVariable String city){
		LOGGER.debug("Starting the ATM locater web service Call");
		AtmListReponse response=new AtmListReponse();
		if(null == city) {
			response.setReturnCode("1");
			response.setStatusMessage("Please enter the city value in the request");
			LOGGER.debug("city name is null in the path variable");
			return response;
		}
		response = locatorService.getAtmByCity(city);
		LOGGER.debug("Ending the ATM locater web service Call");
		
		return response;
	}
}
