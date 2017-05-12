package com.moblab.zsolt.moblab.mock;

import com.moblab.zsolt.moblab.mock.interceptor.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

	public static Response call(Request request) {
		MockInterceptor mockInterceptor = new MockInterceptor();
		return mockInterceptor.process(request);
	}
}