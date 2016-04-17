package com.common;

import com.common.model.CustomHttpRequest;
import com.common.model.CustomHttpResponse;
import com.common.service.HttpRequestService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProducesJsonTest {
	
	@Test
	public void checkResourceProducesJSON() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(HttpRequestsTest.BASE_URL + "/resttest/json")
				.method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getHeaders().containsKey("Content-Type")).isTrue();
		Assertions.assertThat(response.getHeaders().get("Content-Type")).isEqualTo("application/json");
		Assertions.assertThat(response.getContent()).isEqualTo("{\"value\":\"JSON\"}");
	}
}
