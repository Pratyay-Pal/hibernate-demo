package com.pc.gpu.entity.sql.dao;

import java.util.List;

import com.pc.gpu.entity.gpudetails;

public interface GpuDao {
	
	public List<String> getCompany();
	public List<String> getGpuNames(String company);
	public gpudetails getGpuDetails(String gpuName);
	
}
