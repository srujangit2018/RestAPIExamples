package com.epam.httpconnection;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

//This is the main helper class, responsible for HTTPClinet Connection establishment and to execute the get and post methods

public class HttpClientConnection {

	public HttpResponse getMethod(String Url) throws ClientProtocolException, IOException {
		

		HttpClient httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(Url);
		HttpResponse res = httpClient.execute(get);
		return res;
	}

	public HttpResponse postMethod(String Url, String payload) throws ClientProtocolException, IOException {
		System.out.println(payload);
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(Url);
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(payload));
		HttpResponse response = httpClient.execute(post);
		System.out.println(response);
		return response;
	}
}
