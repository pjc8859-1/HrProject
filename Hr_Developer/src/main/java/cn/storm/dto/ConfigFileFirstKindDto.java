package cn.storm.dto;

import java.io.Serializable;

public class ConfigFileFirstKindDto implements Serializable{
	private String firstKindId;
	private String firstKindName;
	public String getFirstKindId() {
		return firstKindId;
	}
	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}
	public String getFirstKindName() {
		return firstKindName;
	}
	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}
	

}
