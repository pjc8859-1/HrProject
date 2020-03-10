package cn.storm.pojo;

/**
 * UsersId entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Short UId;
	private String UName;
	private String UTrueName;
	private String UPassword;
	private String UPosition;
	// Property accessors

	public Short getUId() {
		return this.UId;
	}

	public void setUId(Short UId) {
		this.UId = UId;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUTrueName() {
		return this.UTrueName;
	}

	public void setUTrueName(String UTrueName) {
		this.UTrueName = UTrueName;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public String getUPosition() {
		return this.UPosition;
	}

	public void setUPosition(String UPosition) {
		this.UPosition = UPosition;
	}

	@Override
	public String toString() {
		return "UsersId [UId=" + UId + ", UName=" + UName + ", UTrueName="
				+ UTrueName + ", UPassword=" + UPassword + ", UPosition="
				+ UPosition + "]";
	}

	 
}