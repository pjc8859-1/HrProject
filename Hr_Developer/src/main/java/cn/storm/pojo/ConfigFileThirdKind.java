package cn.storm.pojo;

/**
 * ConfigFileThirdKindId entity. @author MyEclipse Persistence Tools
 */

public class ConfigFileThirdKind implements java.io.Serializable {

	// Fields

	private Short ftkId;
	private String firstKindId;
	private String firstKindName;
	private String secondKindId;
	private String secondKindName;
	private String thirdKindId;
	private String thirdKindName;
	private String thirdKindSaleId;
	private String thirdKindIsRetail;

 
	// Property accessors

	public Short getFtkId() {
		return this.ftkId;
	}

	public void setFtkId(Short ftkId) {
		this.ftkId = ftkId;
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

	public String getThirdKindId() {
		return this.thirdKindId;
	}

	public void setThirdKindId(String thirdKindId) {
		this.thirdKindId = thirdKindId;
	}

	public String getThirdKindName() {
		return this.thirdKindName;
	}

	public void setThirdKindName(String thirdKindName) {
		this.thirdKindName = thirdKindName;
	}

	public String getThirdKindSaleId() {
		return this.thirdKindSaleId;
	}

	public void setThirdKindSaleId(String thirdKindSaleId) {
		this.thirdKindSaleId = thirdKindSaleId;
	}

	public String getThirdKindIsRetail() {
		return this.thirdKindIsRetail;
	}

	public void setThirdKindIsRetail(String thirdKindIsRetail) {
		this.thirdKindIsRetail = thirdKindIsRetail;
	}

	@Override
	public String toString() {
		return "ConfigFileThirdKindId [ftkId=" + ftkId + ", firstKindId="
				+ firstKindId + ", firstKindName=" + firstKindName
				+ ", secondKindId=" + secondKindId + ", secondKindName="
				+ secondKindName + ", thirdKindId=" + thirdKindId
				+ ", thirdKindName=" + thirdKindName + ", thirdKindSaleId="
				+ thirdKindSaleId + ", thirdKindIsRetail=" + thirdKindIsRetail
				+ "]";
	}

	
}