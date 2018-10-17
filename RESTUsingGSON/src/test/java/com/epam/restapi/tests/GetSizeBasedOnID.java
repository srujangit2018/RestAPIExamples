package com.epam.restapi.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.epam.pojomappers.Response2_POJO;
import com.epam.pojomappers.Details;
import com.google.gson.Gson;

/*
Q) From below json, get size based on "id": "b6d00783-9f8c-40b8-ad78-956b0299478c", 
the Input json file is placed in the location: --> src\test\resources\JSONFiles\response2.json
*/
public class GetSizeBasedOnID {

	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = null;
		String id = "b6d00783-9f8c-40b8-ad78-956b0299478c";
		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\JSONFiles\\response2.json"));
			Response2_POJO pojo = gson.fromJson(br, Response2_POJO.class);

			Details[] details = pojo.getState();
			boolean idExist=false;
			for (Details details_verf : details) {
				if (details_verf.getId().equals(id)) {
					System.out.println(details_verf.getSize());
					idExist=true;
					}
			}
			
			if(!idExist) {
				System.out.println("Please Provide a Valid ID");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
