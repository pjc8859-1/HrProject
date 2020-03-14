package cn.storm.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

public class MajorManagerDto implements Serializable{
	private String firstkindid;
	private String secondkindid;
	private String thirdkindid;
	private String majorkindid;
	private String majorid;
	private Date begintime;
	private Date endtime;
	public String getFirstkindid() {
		return firstkindid;
	}
	public void setFirstkindid(String firstkindid) {
		this.firstkindid = firstkindid;
	}
	public String getSecondkindid() {
		return secondkindid;
	}
	public void setSecondkindid(String secondkindid) {
		this.secondkindid = secondkindid;
	}
	public String getThirdkindid() {
		return thirdkindid;
	}
	public void setThirdkindid(String thirdkindid) {
		this.thirdkindid = thirdkindid;
	}
	public String getMajorkindid() {
		return majorkindid;
	}
	public void setMajorkindid(String majorkindid) {
		this.majorkindid = majorkindid;
	}
	public String getMajorid() {
		return majorid;
	}
	public void setMajorid(String majorid) {
		this.majorid = majorid;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "MajorManagerDto [firstkindid=" + firstkindid
				+ ", secondkindid=" + secondkindid + ", thirdkindid="
				+ thirdkindid + ", majorkindid=" + majorkindid + ", majorid="
				+ majorid + ", begintime=" + begintime + ", endtime=" + endtime
				+ "]";
	}
	

}
