package cn.storm.pojo;

/**
 * SalaryStandardDetailsId entity. @author MyEclipse Persistence Tools
 */

public class SalaryStandardDetails implements java.io.Serializable {

	// Fields

	private Short sdtId;
	private String standardId;
	private String standardName;
	private Short itemId;
	private String itemName;
	private Double salary;
	// Property accessors

	public Short getSdtId() {
		return this.sdtId;
	}

	public void setSdtId(Short sdtId) {
		this.sdtId = sdtId;
	}

	public String getStandardId() {
		return this.standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getStandardName() {
		return this.standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

	public Short getItemId() {
		return this.itemId;
	}

	public void setItemId(Short itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SalaryStandardDetailsId [sdtId=" + sdtId + ", standardId="
				+ standardId + ", standardName=" + standardName + ", itemId="
				+ itemId + ", itemName=" + itemName + ", salary=" + salary
				+ "]";
	}

	
}