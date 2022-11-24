package com.digitalBooks.controller.apiHelper;

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class HttpComponentsClientHttpRequestWithBodyFactory extends HttpComponentsClientHttpRequestFactory {

	@Override
	protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
		if (httpMethod == HttpMethod.GET) {
			return new HttpGetRequestWithEntity(uri);
		}
		return super.createHttpUriRequest(httpMethod, uri);
	}
}
