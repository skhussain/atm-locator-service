package com.locatorService.service;

import org.springframework.stereotype.Service;

import com.locatorService.models.AtmListReponse;
@Service
public interface AtmLocatorService {
	AtmListReponse getAtmList();
	AtmListReponse getAtmByCity(String city);
	
}
