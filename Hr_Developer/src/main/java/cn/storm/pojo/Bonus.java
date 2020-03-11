package cn.storm.pojo;

import java.sql.Timestamp;

/**
 * BonusId entity. @author MyEclipse Persistence Tools
 */

public class Bonus implements java.io.Serializable {

	// Fields
	//111   3位 最大 2^3-1 =7
	private Short bonId;//因为用的是short所以最大值是65535
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private String humanId;
	private String humanName;
	private String bonusItem;
	private Double bonusWorth;
	private String bonusDegree;
	private String remark;
	private String register;
	private String checker;
	private Timestamp registTime;
	private Timestamp checkTime;
	private Short checkStatus;

	 
	// Property accessors

	public Short getBonId() {
		return this.bonId;
	}

	public void setBonId(Short bonId) {
		this.bonId = bonId;
	}

	public String getMajorKindId() {
		return this.majorKindId;
	}

	public void setMajorKindId(String majorKindId) {
		this.majorKindId = majorKindId;
	}

	public String getMajorKindName() {
		return this.majorKindName;
	}

	public void setMajorKindName(String majorKindName) {
		this.majorKindName = majorKindName;
	}

	public String getMajorId() {
		return this.majorId;
	}

	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getHumanId() {
		return this.humanId;
	}

	public void setHumanId(String humanId) {
		this.humanId = humanId;
	}

	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getBonusItem() {
		return this.bonusItem;
	}

	public void setBonusItem(String bonusItem) {
		this.bonusItem = bonusItem;
	}

	public Double getBonusWorth() {
		return this.bonusWorth;
	}

	public void setBonusWorth(Double bonusWorth) {
		this.bonusWorth = bonusWorth;
	}

	public String getBonusDegree() {
		return this.bonusDegree;
	}

	public void setBonusDegree(String bonusDegree) {
		this.bonusDegree = bonusDegree;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Timestamp getRegistTime() {
		return this.registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public Timestamp getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Timestamp checkTime) {
		this.checkTime = checkTime;
	}

	public Short getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Short checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString() {
		return "BonusId [bonId=" + bonId + ", majorKindId=" + majorKindId
				+ ", majorKindName=" + majorKindName + ", majorId=" + majorId
				+ ", majorName=" + majorName + ", humanId=" + humanId
				+ ", humanName=" + humanName + ", bonusItem=" + bonusItem
				+ ", bonusWorth=" + bonusWorth + ", bonusDegree=" + bonusDegree
				+ ", remark=" + remark + ", register=" + register
				+ ", checker=" + checker + ", registTime=" + registTime
				+ ", checkTime=" + checkTime + ", checkStatus=" + checkStatus
				+ "]";
	}

	
}