package cn.storm.pojo;

import java.sql.Timestamp;

/**
 * TrainingId entity. @author MyEclipse Persistence Tools
 */

public class Training implements java.io.Serializable {

	// Fields

	private Short traId;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private String humanId;
	private String humanName;
	private String trainingItem;
	private Timestamp trainingTime;
	private Integer trainingHour;
	private String trainingDegree;
	private String register;
	private String checker;
	private Timestamp registTime;
	private Timestamp checkTime;
	private Short checkstatus;
	private String remark;

	// Property accessors

	public Short getTraId() {
		return this.traId;
	}

	public void setTraId(Short traId) {
		this.traId = traId;
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

	public String getTrainingItem() {
		return this.trainingItem;
	}

	public void setTrainingItem(String trainingItem) {
		this.trainingItem = trainingItem;
	}

	public Timestamp getTrainingTime() {
		return this.trainingTime;
	}

	public void setTrainingTime(Timestamp trainingTime) {
		this.trainingTime = trainingTime;
	}

	public Integer getTrainingHour() {
		return this.trainingHour;
	}

	public void setTrainingHour(Integer trainingHour) {
		this.trainingHour = trainingHour;
	}

	public String getTrainingDegree() {
		return this.trainingDegree;
	}

	public void setTrainingDegree(String trainingDegree) {
		this.trainingDegree = trainingDegree;
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

	public Short getCheckstatus() {
		return this.checkstatus;
	}

	public void setCheckstatus(Short i) {
		this.checkstatus = i;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TrainingId [traId=" + traId + ", majorKindId=" + majorKindId
				+ ", majorKindName=" + majorKindName + ", majorId=" + majorId
				+ ", majorName=" + majorName + ", humanId=" + humanId
				+ ", humanName=" + humanName + ", trainingItem=" + trainingItem
				+ ", trainingTime=" + trainingTime + ", trainingHour="
				+ trainingHour + ", trainingDegree=" + trainingDegree
				+ ", register=" + register + ", checker=" + checker
				+ ", registTime=" + registTime + ", checkTime=" + checkTime
				+ ", checkstatus=" + checkstatus + ", remark=" + remark + "]";
	}
		
}