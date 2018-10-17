package com.epam.pojomappers;

public class Support {
	private String status;

	private String[] reasons;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getReasons() {
		return reasons;
	}

	public void setReasons(String[] reasons) {
		this.reasons = reasons;
	}

	@Override
	public String toString() {
		return "ClassPojo [status = " + status + ", reasons = " + reasons + "]";
	}
}
