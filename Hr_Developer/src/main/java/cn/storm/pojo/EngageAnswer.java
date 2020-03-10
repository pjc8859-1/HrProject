package cn.storm.pojo;

import java.sql.Timestamp;

/**
 * EngageAnswerId entity. @author MyEclipse Persistence Tools
 */

public class EngageAnswer implements java.io.Serializable {

	// Fields

	private Short ansId;
	private String answerNumber;
	private String examNumber;
	private Short resumeId;
	private Short interviewId;
	private String humanName;
	private String humanIdcard;
	private String majorKindId;
	private String majorKindName;
	private String majorId;
	private String majorName;
	private Timestamp testTime;
	private String useTime;
	private Double totalPoint;

	
	// Property accessors

	public Short getAnsId() {
		return this.ansId;
	}

	public void setAnsId(Short ansId) {
		this.ansId = ansId;
	}

	public String getAnswerNumber() {
		return this.answerNumber;
	}

	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}

	public String getExamNumber() {
		return this.examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public Short getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Short resumeId) {
		this.resumeId = resumeId;
	}

	public Short getInterviewId() {
		return this.interviewId;
	}

	public void setInterviewId(Short interviewId) {
		this.interviewId = interviewId;
	}

	public String getHumanName() {
		return this.humanName;
	}

	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}

	public String getHumanIdcard() {
		return this.humanIdcard;
	}

	public void setHumanIdcard(String humanIdcard) {
		this.humanIdcard = humanIdcard;
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

	public Timestamp getTestTime() {
		return this.testTime;
	}

	public void setTestTime(Timestamp testTime) {
		this.testTime = testTime;
	}

	public String getUseTime() {
		return this.useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public Double getTotalPoint() {
		return this.totalPoint;
	}

	public void setTotalPoint(Double totalPoint) {
		this.totalPoint = totalPoint;
	}

	@Override
	public String toString() {
		return "EngageAnswerId [ansId=" + ansId + ", answerNumber="
				+ answerNumber + ", examNumber=" + examNumber + ", resumeId="
				+ resumeId + ", interviewId=" + interviewId + ", humanName="
				+ humanName + ", humanIdcard=" + humanIdcard + ", majorKindId="
				+ majorKindId + ", majorKindName=" + majorKindName
				+ ", majorId=" + majorId + ", majorName=" + majorName
				+ ", testTime=" + testTime + ", useTime=" + useTime
				+ ", totalPoint=" + totalPoint + "]";
	}

	

}