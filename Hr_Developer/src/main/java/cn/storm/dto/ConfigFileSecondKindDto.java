package cn.storm.dto;

import java.io.Serializable;

public class ConfigFileSecondKindDto implements Serializable{
private String secondKindId;
private String secondKindName;
public String getSecondKindId() {
	return secondKindId;
}
public void setSecondKindId(String secondKindId) {
	this.secondKindId = secondKindId;
}
public String getSecondKindName() {
	return secondKindName;
}
public void setSecondKindName(String secondKindName) {
	this.secondKindName = secondKindName;
}

}
