package com.common;

import com.common.model.CustomHttpRequest;
import com.common.model.CustomHttpResponse;
import com.common.service.HttpRequestService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SecurityTest {
	
	@Test
	public void checkPermitAll() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/permit")
			   .method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContent()).isEqualTo("Allowed");
	}
	
	@Test
	public void checkDenyAll() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/deny")
			   .method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(403);
	}
}
