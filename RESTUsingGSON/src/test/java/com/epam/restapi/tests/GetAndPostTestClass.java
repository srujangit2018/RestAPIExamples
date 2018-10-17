package com.epam.restapi.tests;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.httpconnection.HttpClientConnection;
import com.epam.pojomappers.GetUserDetails;
import com.epam.pojomappers.NewUserReg;
import com.epam.root.BaseClass;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

// This class is dealing with GET and POST method calls, using Apache HTTP Client.

public class GetAndPostTestClass extends BaseClass {
	HttpClientConnection client;
	String url;
	Gson gson;
	
	@BeforeTest
	public void init() {
		client = new HttpClientConnection();
		BaseClass.getDefaultConfig();
		gson = new Gson();
	}
	
	//Post method Example
	@Test(priority=1)
	public void registerUser() {
		url = pros.getProperty("Uri") + pros.getProperty("endpoint_getUsr");
		String name = pros.getProperty("userName");
		String job =pros.getProperty("job");
		NewUserReg userReg = new NewUserReg(name,job);
		System.out.println(gson.toJson(userReg));
		HttpResponse response;
		try {
			response = client.postMethod(url, gson.toJson(userReg));
			Assert.assertEquals(BaseClass.Res_code_201, response.getStatusLine().getStatusCode(), "[Error Msg] response Code not 201  ");
			JSONObject jsonObj = new JSONObject(EntityUtils.toString(response.getEntity()));
			Assert.assertEquals(name, jsonObj.getString("name"),"[Error Msg] Name mismatch ");
			Assert.assertEquals(job, jsonObj.getString("job"),"[Error Msg] password  mismatch ");			
			
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
	
	//Get Method Example
	@Test(priority=2)
	public void getUsers() {
		try {
			
			url = pros.getProperty("Uri") + pros.getProperty("endpoint_getUsr");
			HttpResponse response= client.getMethod(url);
			Assert.assertEquals(BaseClass.Res_code_200, response.getStatusLine().getStatusCode(), "not a Valid response code, Please verify inputs ");
			JSONObject jsonObj = new JSONObject(EntityUtils.toString(response.getEntity()));
			JSONArray JsonArray=jsonObj.getJSONArray("data");
			System.out.println(JsonArray.length());
			Assert.assertEquals(true, JsonArray.length()<=3, "[Error Msg] more than three users are displyed per page");
			GetUserDetails javaObj = gson.fromJson(jsonObj.toString(), GetUserDetails.class);
			Assert.assertEquals(12, javaObj.getTotal(), "[Error Msg]total Number of user not matched as per Database");
			for (int i = 0; i < JsonArray.length(); i++) 
				System.out.println("ID --->"+JsonArray.getJSONObject(i).get("id") + ",  Name: -->" +JsonArray.getJSONObject(i).get("name"));
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	//get Method example with Pagination Range for Users
	@Test(priority=3)
	public void getRequiredUsers() {
		try {
			
			url = pros.getProperty("Uri") + pros.getProperty("endpoint_userlist");
			HttpResponse response= client.getMethod(url);
			Assert.assertEquals(BaseClass.Res_code_200, response.getStatusLine().getStatusCode(),"not a Valid response code, Please verify inputs ");
			JSONObject jsonObj = new JSONObject(EntityUtils.toString(response.getEntity()));
			JSONArray JsonArray=jsonObj.getJSONArray("data");
			System.out.println(JsonArray.length());
			Assert.assertEquals(true, JsonArray.length()<=3, "[Error Msg] more than three users are displyed per page");
			GetUserDetails javaObj = gson.fromJson(jsonObj.toString(), GetUserDetails.class);
			Assert.assertEquals(12, javaObj.getTotal(), "[Error Msg]total Number of user not matched as per Database");
			for (int i = 0; i < JsonArray.length(); i++) 
				System.out.println("ID --->"+JsonArray.getJSONObject(i).get("id") + ",  Name: -->" +JsonArray.getJSONObject(i).get("first_name")+" "+JsonArray.getJSONObject(i).get("last_name"));
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (ClientProtocolException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
}	

