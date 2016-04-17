package com.common.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.common.model.CustomHttpRequest;
import com.common.model.CustomHttpResponse;
import com.common.model.CustomHttpResponse.CustomHttpResponseBuilder;

public class HttpRequestService {

	public static CustomHttpResponse sendRequest(CustomHttpRequest request) {
		CustomHttpResponseBuilder response = null;
		try {
			response = new CustomHttpResponseBuilder();

			URL obj = new URL(request.getUrl());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod(request.getMethod());

			Map<String, String> headers = request.getHeaders();
			for (String headerName : headers.keySet()) {
				con.setRequestProperty(headerName, headers.get(headerName));
			}

			if (!request.getMethod().equals("GET")) {
				con.setDoOutput(true);

				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(request.getContent());
				wr.flush();
				wr.close();
			}

			response.status(con.getResponseCode());
			
			Map<String,List<String>> responseHeaders = con.getHeaderFields();
			for(String headerName: responseHeaders.keySet()) {
				response.header(headerName, responseHeaders.get(headerName).get(0));
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			response.content(content.toString());

			return response.build();
		} catch(IOException e) {
			response.content(e.getMessage());
			return response.build();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}