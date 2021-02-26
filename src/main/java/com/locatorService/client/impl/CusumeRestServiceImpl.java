package com.locatorService.client.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.locatorService.client.ConsumeRestService;
@Service
public class CusumeRestServiceImpl implements ConsumeRestService {

	@Override
	public <T> ResponseEntity<T> getforEntity(String url, Class<T> t) {
		ResponseEntity<T> forEntity = new RestTemplate().getForEntity(url, t);
		return forEntity;
	}

}
