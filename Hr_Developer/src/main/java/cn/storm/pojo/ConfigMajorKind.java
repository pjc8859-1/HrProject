package cn.storm.pojo;

/**
 * ConfigMajorKindId entity. @author MyEclipse Persistence Tools
 */

public class ConfigMajorKind implements java.io.Serializable {

	// Fields

	private Short mfkId;
	private String majorKindId;
	private String majorKindName;

 
 
	// Property accessors

	public Short getMfkId() {
		return this.mfkId;
	}

	public void setMfkId(Short mfkId) {
		this.mfkId = mfkId;
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

	@Override
	public String toString() {
		return "ConfigMajorKindId [mfkId=" + mfkId + ", majorKindId="
				+ majorKindId + ", majorKindName=" + majorKindName + "]";
	}

	 
}