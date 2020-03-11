package cn.storm.pojo;

/**
 * ConfigQuestionSecondKindId entity. @author MyEclipse Persistence Tools
 */

public class ConfigQuestionSecondKind implements java.io.Serializable {

	// Fields

	private Short qskId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;

	// Property accessors

	public Short getQskId() {
		return this.qskId;
	}

	public void setQskId(Short qskId) {
		this.qskId = qskId;
	}

	public String getFirstKindId() {
		return this.firstKindId;
	}

	public void setFirstKindId(String firstKindId) {
		this.firstKindId = firstKindId;
	}

	public String getFirstKindName() {
		return this.firstKindName;
	}

	public void setFirstKindName(String firstKindName) {
		this.firstKindName = firstKindName;
	}

	public String getSecondKindId() {
		return this.secondKindId;
	}

	public void setSecondKindId(String secondKindId) {
		this.secondKindId = secondKindId;
	}

	public String getSecondKindName() {
		return this.secondKindName;
	}

	public void setSecondKindName(String secondKindName) {
		this.secondKindName = secondKindName;
	}

	@Override
	public String toString() {
		return "ConfigQuestionSecondKindId [qskId=" + qskId + ", firstKindId="
				+ firstKindId + ", firstKindName=" + firstKindName
				+ ", secondKindId=" + secondKindId + ", secondKindName="
				+ secondKindName + "]";
	}

}