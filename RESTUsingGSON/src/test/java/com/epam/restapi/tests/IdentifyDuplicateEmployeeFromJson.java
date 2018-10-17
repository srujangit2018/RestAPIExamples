package com.epam.restapi.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;

import com.epam.pojomappers.EmpName;
import com.epam.pojomappers.EmpName_Pojo;
import com.google.gson.Gson;

/*
Q) Based on last name get duplicate employee from json 
the Input json file is placed in the location: --> src\test\resources\JSONFiles\response.json
*/
public class IdentifyDuplicateEmployeeFromJson {

	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = null;
		String lastName = "Dillon";

		try {
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\JSONFiles\\response.json"));
			EmpName_Pojo empDetails = gson.fromJson(br, EmpName_Pojo.class);
			EmpName[] names = empDetails.getName();
			HashSet<String> duplicateVerf = new HashSet<String>();
			for (EmpName string : names) {
				if (string.getLastName().equals(lastName)) {
					if (!duplicateVerf.add(string.getName()))
						System.out.println(string.getName()+" ---> is the duplicate employee of the List");
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
