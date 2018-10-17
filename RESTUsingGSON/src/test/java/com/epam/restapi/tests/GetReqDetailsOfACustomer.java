package com.epam.restapi.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.epam.pojomappers.Address;
import com.epam.pojomappers.Owner;
import com.epam.pojomappers.Response1_POJO;
import com.epam.pojomappers.Waiter;
import com.google.gson.Gson;

/*
 Q) Based on name: , get address houseNumber and later  get waiter -> salary
 the Input json file is placed in the location: --> src\test\resources\JSONFiles\response1.json
*/
public class GetReqDetailsOfACustomer {

	
	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = null;
		String name ="Christian";
		
		
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\JSONFiles\\response1.json"));
			Response1_POJO response = gson.fromJson(br, Response1_POJO.class);
			
			Owner owner = response.getOwner();
			if(owner.getName().equals(name)) {
				Address addr = owner.getAddress();
				Waiter waiter = response.getWaiter();
				System.out.println(addr.getHouseNumber());
				System.out.println(waiter.getSalary());
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	

}
