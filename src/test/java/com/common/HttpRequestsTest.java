package com.common;

import com.common.model.CustomHttpRequest.CustomHttpRequestBuilder;
import com.common.model.CustomHttpResponse;
import com.common.service.HttpRequestService;
import com.google.common.collect.Maps;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Map;

public class HttpRequestsTest {

	@Test
	public void getRequestTest() {
		CustomHttpRequestBuilder request = new CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/get")
			   .method("GET")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContent()).isEqualTo("GetResponse");
	}
	
	@Test
	public void postRequestTest() {
		CustomHttpRequestBuilder request = new CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/post")
			   .method("POST")
			   .header("Content-Type", "text/plain")
			   .content("someContent");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContent()).isEqualTo("someContent");
	}
	
	@Test
	public void putRequestTest() {
		CustomHttpRequestBuilder request = new CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		request.url(App2.BASE_URL + "/resttest/put")
			   .method("PUT")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContent()).isEqualTo("PutResponse");
	}
	
	@Test
	public void deleteRequestTest() {
		CustomHttpRequestBuilder request = new CustomHttpRequestBuilder();
		CustomHttpResponse response = null;
		
		Map<String, String> headers = Maps.newHashMap();
		headers.put("Content-Type", "text/plain");
		
		request.url(App2.BASE_URL + "/resttest/delete")
			   .method("DELETE")
			   .header("Content-Type", "text/plain");
		
		response = HttpRequestService.sendRequest(request.build());
		
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatus()).isEqualTo(200);
		Assertions.assertThat(response.getContent()).isEqualTo("DeleteResponse");
	}
}
