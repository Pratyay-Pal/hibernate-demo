package com.pc.gpu.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pc.gpu.bean.company.CompanyResponse;
import com.pc.gpu.bean.gpudetails.GpuDetailsRequest;
import com.pc.gpu.bean.gpudetails.GpuDetailsResponse;
import com.pc.gpu.bean.gpuname.GpuNameRequest;
import com.pc.gpu.bean.gpuname.GpuNameResponse;
import com.pc.gpu.entity.gpudetails;
import com.pc.gpu.entity.sql.dao.GpuDao;

@RestController
@RequestMapping("/gpu")
public class AllController {

	private final Logger logger = LogManager.getLogger(AllController.class);
	
	@Autowired
	private GpuDao gpuDao;
	
	@GetMapping("/company")
	public CompanyResponse getGpuCompany()
	{
		logger.info("Inside getGpuCompany");		
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setCompany(gpuDao.getCompany());
				
		return companyResponse;
	}
	
	@PostMapping("/gpuname")
	public GpuNameResponse getGpuName(@RequestBody GpuNameRequest gpuNameRequest)
	{
		logger.info("Inside getGpuName");	
		logger.info("GPU List requested for company : "+gpuNameRequest.getCompany());
		GpuNameResponse gpuNameResponse = new GpuNameResponse();
		gpuNameResponse.setGpuname(gpuDao.getGpuNames(gpuNameRequest.getCompany()));				
		return gpuNameResponse;
	}
	
	@PostMapping("/gpudetails")
	public GpuDetailsResponse getGpuDetails(@RequestBody GpuDetailsRequest gpuDetailsRequest)
	{
		logger.info("Inside getGpuDetails");
		logger.info("GPU Details requested for company : "+gpuDetailsRequest.getGpuname());
		gpudetails gpu = gpuDao.getGpuDetails(gpuDetailsRequest.getGpuname());		
		GpuDetailsResponse gpuDetailsResponse = new GpuDetailsResponse();
		gpuDetailsResponse.setArchitecture(gpu.getArchitecture());
		gpuDetailsResponse.setClockspeed(gpu.getClockspeed());
		gpuDetailsResponse.setCores(gpu.getCores());
		gpuDetailsResponse.setGpuname(gpu.getGpuname());
		gpuDetailsResponse.setMemorytype(gpu.getMemorytype());
		gpuDetailsResponse.setPrice(gpu.getPrice());
		gpuDetailsResponse.setScore(gpu.getScore());
		gpuDetailsResponse.setVram(gpu.getVram());		
		return gpuDetailsResponse;
	}	
}