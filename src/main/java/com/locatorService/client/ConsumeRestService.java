package com.locatorService.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ConsumeRestService {
		<T> ResponseEntity<T> getforEntity(String url,Class<T> t);
}
