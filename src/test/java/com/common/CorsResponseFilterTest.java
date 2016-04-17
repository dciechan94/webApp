package com.common;


import com.common.model.CustomHttpRequest;
import com.common.model.CustomHttpResponse;
import com.common.service.HttpRequestService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CorsResponseFilterTest {

	
	@Test
	public void appendedCorsHeadersTest() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/get")
			   .method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getHeaders().containsKey("Access-Control-Allow-Headers")).isTrue();
		Assertions.assertThat(response.getHeaders().containsKey("Access-Control-Allow-Methods")).isTrue();
		Assertions.assertThat(response.getHeaders().containsKey("Access-Control-Allow-Origin")).isTrue();
	}
}
