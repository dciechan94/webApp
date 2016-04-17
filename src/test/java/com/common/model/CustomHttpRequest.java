package com.common.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class CustomHttpRequest {
	private final String url;
	private final String method;
	private final String content;
	private final Map<String, String> headers = Maps.newHashMap();
	
	private CustomHttpRequest(CustomHttpRequestBuilder builder) {
		url = builder.url;
		method = builder.method;
		content = builder.content;
		headers.putAll(builder.headers);
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getMethod() {
		return method;
	}

	public String getContent() {
		return content;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	
	public static class CustomHttpRequestBuilder {
		private String url = "";
		private String method = "";
		private String content = "";
		private Map<String, String> headers = Maps.newHashMap();
		
		public CustomHttpRequestBuilder url(String pUrl) {
			url = pUrl;
			return this;
		}
		
		public CustomHttpRequestBuilder method(String pMethod) {
			method = pMethod;
			return this;
		}
		
		public CustomHttpRequestBuilder content(String pContent) {
			content = pContent;
			return this;
		}
		
		public CustomHttpRequestBuilder headers(Map<String, String> pHeaders) {
			headers.putAll(pHeaders);
			return this;
		}
		
		public CustomHttpRequestBuilder header(String name, String value) {
			headers.put(name, value);
			return this;
		}
		
		public CustomHttpRequest build() {
			return new CustomHttpRequest(this);
		}
	}
}
