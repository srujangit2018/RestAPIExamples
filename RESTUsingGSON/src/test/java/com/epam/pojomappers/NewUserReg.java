package com.epam.pojomappers;

public class NewUserReg {

	private String name;
	private String job;

	public NewUserReg(String name, String job) {
		this.job = job;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
