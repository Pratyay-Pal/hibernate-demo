package com.pc.gpu.bean.gpuname;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class GpuNameRequest {

	@Valid
	@NotBlank(message="company cannot be empty")
	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	

}
