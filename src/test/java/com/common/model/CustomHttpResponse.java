package com.common.model;

import java.util.Map;

import com.google.common.collect.Maps;

public class CustomHttpResponse {
	private int status;
	private String content;
	private final Map<String, String> headers = Maps.newHashMap();

	
	private CustomHttpResponse(CustomHttpResponseBuilder builder) {
		status = builder.status;
		content = builder.content;
		headers.putAll(builder.headers);
	}
	
	public int getStatus() {
		return status;
	}

	public String getContent() {
		return content;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	
	public static class CustomHttpResponseBuilder {
		private int status;
		private String content;
		private Map<String, String> headers = Maps.newHashMap();
		
		public CustomHttpResponseBuilder status(int pStatus) {
			status = pStatus;
			return this;
		}
		
		public CustomHttpResponseBuilder content(String pContent) {
			content = pContent;
			return this;
		}
		
		public CustomHttpResponseBuilder header(String name, String value) {
			headers.put(name, value);
			return this;
		}
		
		public CustomHttpResponseBuilder headers(Map<String, String> pHeaders) {
			headers.putAll(pHeaders);
			return this;
		}
		
		public CustomHttpResponse build() {
			return new CustomHttpResponse(this);
		}
	}
}
