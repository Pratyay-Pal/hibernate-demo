package com.pc.gpu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gpudetails")
public class gpudetails {

	@Column(name="gpudetesid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gpuid;
	
	@Id
	@Column(name="gpuname")
	private String gpuname;
	
	@Column(name="vram")
	private int vram;
	
	@Column(name="cores")
	private int cores;	
	
	@Column(name="clockspeed")
	private int clockspeed;
	
	@Column(name="memorytype")
	private String memorytype;
	
	@Column(name="architecture")
	private String architecture;

	@Column(name="price")
	private int price;
	
	@Column(name="3dmarkscore")
	private int score;
	
	public int getGpuid() {
		return gpuid;
	}

	public void setGpuid(int gpuid) {
		this.gpuid = gpuid;
	}

	public String getGpuname() {
		return gpuname;
	}

	public void setGpuname(String gpuname) {
		this.gpuname = gpuname;
	}

	public int getVram() {
		return vram;
	}

	public void setVram(int vram) {
		this.vram = vram;
	}

	public int getCores() {
		return cores;
	}

	public void setCores(int cores) {
		this.cores = cores;
	}

	public int getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(int clockspeed) {
		this.clockspeed = clockspeed;
	}

	public String getMemorytype() {
		return memorytype;
	}

	public void setMemorytype(String memorytype) {
		this.memorytype = memorytype;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "gpudetails [gpuid=" + gpuid + ", gpuname=" + gpuname + ", vram=" + vram + ", cores=" + cores
				+ ", clockspeed=" + clockspeed + ", memorytype=" + memorytype + ", architecture=" + architecture
				+ ", price=" + price + ", score=" + score + "]";
	}	
	
}
