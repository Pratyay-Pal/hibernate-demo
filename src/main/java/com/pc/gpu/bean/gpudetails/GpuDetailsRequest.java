package com.pc.gpu.bean.gpudetails;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public class GpuDetailsRequest {

	@Valid
	@NotBlank(message="gpuname cannot be empty")
	private String gpuname;

	public String getGpuname() {
		return gpuname;
	}

	public void setGpuname(String gpuname) {
		this.gpuname = gpuname;
	}	

}
