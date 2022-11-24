package com.digitalBooks.controller.apiHelper;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.springframework.http.HttpMethod;

final class HttpGetRequestWithEntity extends HttpEntityEnclosingRequestBase {
	  public HttpGetRequestWithEntity(final URI uri) {
	        super.setURI(uri);
	    }

	    @Override
	    public String getMethod() {
	        return HttpMethod.GET.name();
	    }
}
