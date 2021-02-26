package com.locatorService.controllerTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.locatorService.controller.AtmLocatoerController;
import com.locatorService.models.ATMBean;
import com.locatorService.models.Address;
import com.locatorService.models.AtmListReponse;
import com.locatorService.service.AtmLocatorService;

public class AtmLocatoerControllerTest {
	
	private AtmLocatoerController controller;
	@Mock
	private AtmLocatorService service;
	@Before
	public void setUp() {
		Mockito.mock(AtmLocatoerController.class);
	}
	@Test
	public void testGetAtmList() {
		when(service.getAtmList()).thenReturn(getDummyAtmList());
		AtmListReponse atmList = controller.getAtmList();
		
		assertNotNull(atmList);
	}
	private AtmListReponse getDummyAtmList() {
		AtmListReponse response=new AtmListReponse();
		ATMBean bean=new ATMBean();
		Address address=new Address();
		address.setCity("mexico");
		address.setHousenumber("389");
		address.setPostalcode("5002");
		address.setStreet("new street");
		bean.setAddress(address);
		bean.setDistance("0");
		bean.setFunctionality("ATM test");
		bean.setType("test ATM");
		return response;
	}
}
