package com.epam.pojomappers;

public class Details {
	private String id;

	private String storage_pool;

	private String managed;

	private Support support;

	private String status;

	private String name;

	private String[] mapped_wwpns;

	private String size;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStorage_pool() {
		return storage_pool;
	}

	public void setStorage_pool(String storage_pool) {
		this.storage_pool = storage_pool;
	}

	public String getManaged() {
		return managed;
	}

	public void setManaged(String managed) {
		this.managed = managed;
	}

	public Support getSupport() {
		return support;
	}

	public void setSupport(Support support) {
		this.support = support;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getMapped_wwpns() {
		return mapped_wwpns;
	}

	public void setMapped_wwpns(String[] mapped_wwpns) {
		this.mapped_wwpns = mapped_wwpns;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", storage_pool = " + storage_pool + ", managed = " + managed + ", support = "
				+ support + ", status = " + status + ", name = " + name + ", mapped_wwpns = " + mapped_wwpns
				+ ", size = " + size + "]";
	}
}