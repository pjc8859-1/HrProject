package cn.storm.pojo;

/**
 * ConfigPublicCharId entity. @author MyEclipse Persistence Tools
 */

public class ConfigPublicChar implements java.io.Serializable {

	// Fields

	private Short pbcId;
	private String attributeKind;
	private String attributeName;

	 
	// Property accessors

	public Short getPbcId() {
		return this.pbcId;
	}

	public void setPbcId(Short pbcId) {
		this.pbcId = pbcId;
	}

	public String getAttributeKind() {
		return this.attributeKind;
	}

	public void setAttributeKind(String attributeKind) {
		this.attributeKind = attributeKind;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Override
	public String toString() {
		return "ConfigPublicCharId [pbcId=" + pbcId + ", attributeKind="
				+ attributeKind + ", attributeName=" + attributeName + "]";
	}

	 
}