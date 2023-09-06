package com.pc.gpu.bean.gpudetails;

public class GpuDetailsResponse {

	private String gpuname;
	private int price;
	private int score;	
	private int vram;
	private int cores;
	private int clockspeed;
	private String memorytype;
	private String architecture;
		

	public String getGpuname() {
		return gpuname;
	}
	public void setGpuname(String gpuname) {
		this.gpuname = gpuname;
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
	@Override
	public String toString() {
		return "GpuDetailsResponse [gpuname=" + gpuname + ", price=" + price + ", score=" + score + ", vram=" + vram
				+ ", cores=" + cores + ", clockspeed=" + clockspeed + ", memorytype=" + memorytype + ", architecture="
				+ architecture + "]";
	}	
	
}
