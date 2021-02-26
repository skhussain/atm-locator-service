package com.locatorService.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.locatorService.client.ConsumeRestService;
import com.locatorService.models.AtmListReponse;

public class AtmLocatorServiceImplTest {
	AtmLocatorServiceImpl serviceImpl;
	public void setUp() {
		Mockito.mock(AtmLocatorServiceImpl.class);
	}
	@Mock
	private ConsumeRestService service;
	@Mock
	private Environment env;
	@Test
	public void getAtmListTest() {
		when(service.getforEntity(Mockito.anyString(),String.class)).thenReturn(new ResponseEntity<String>(HttpStatus.ACCEPTED));
		when(env.getRequiredProperty(Mockito.anyString())).thenReturn("");
		AtmListReponse atmList = serviceImpl.getAtmList();
		assertNotNull(atmList);
		
	}
}
