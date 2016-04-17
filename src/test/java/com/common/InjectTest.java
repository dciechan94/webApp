package com.common;

import com.common.model.CustomHttpRequest;
import com.common.model.CustomHttpResponse;
import com.common.service.HttpRequestService;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class InjectTest {
	@Test
	public void checkInjection() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/inject")
			   .method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getContent()).isEqualTo("Injected");
	}

	@Test
	public void checkLoggerInjection() {
		CustomHttpRequest.CustomHttpRequestBuilder request = new CustomHttpRequest.CustomHttpRequestBuilder();
		CustomHttpResponse response = null;

		request.url(App2.BASE_URL + "/resttest/injectLogger")
				.method("GET")
				.header("Content-Type", "text/plain");

		response = HttpRequestService.sendRequest(request.build());

		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getContent()).isEqualTo("Injected");
	}
}
