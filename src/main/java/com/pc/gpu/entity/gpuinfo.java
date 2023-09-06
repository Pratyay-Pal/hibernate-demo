package com.pc.gpu.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gpuinfo")
public class gpuinfo {

	@Id
	@Column(name="gpuid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gpuid;
	
	//UNCOMMENT FOR SINGLE TABLE DATA INSERT
//	@Column(name="gpuname")
//	private String gpuname;
	
	//MUST BE USED FOR FOREIGN KEY MAPPING
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="gpuname")
	private gpudetails gpuDetails;
	
	@Column(name="company")
	private String company;
	
	public int getGpuid() {
		return gpuid;
	}

	public void setGpuid(int gpuid) {
		this.gpuid = gpuid;
	}

	public gpudetails getGpuDetails() {
		return gpuDetails;
	}

	public void setGpuDetails(gpudetails gpuDetails) {
		this.gpuDetails = gpuDetails;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "gpuinfo [gpuid=" + gpuid + ", gpuDetails=" + gpuDetails + ", company=" + company + "]";
	}
	
	
}
