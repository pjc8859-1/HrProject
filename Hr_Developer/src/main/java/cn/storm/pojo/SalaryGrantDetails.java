package cn.storm.pojo;

/**
 * SalaryGrantDetailsId entity. @author MyEclipse Persistence Tools
 */

public class SalaryGrantDetails implements java.io.Serializable {

	// Fields

	private Short grdId;
	private String salaryGrantId;
	private String humanId;
	private String humanName;
	private Double bounsSum;
	private Double saleSum;
	private Double deductSum;
	private Double salaryStandardSum;
	private Double salaryPaidSum;

	 
	// Property accessors

	public Short getGrdId() {
		return this.grdId;
	}

	public void setGrdId(Short grdId) {
		this.grdId = grdId;
	}

	public String getSalaryGrantId() {
		return this.salaryGrantId;
	}

	public void setSalaryGrantId(String salaryGrantId) {
		this.salaryGrantId = salaryGrantId;
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

	public Double getBounsSum() {
		return this.bounsSum;
	}

	public void setBounsSum(Double bounsSum) {
		this.bounsSum = bounsSum;
	}

	public Double getSaleSum() {
		return this.saleSum;
	}

	public void setSaleSum(Double saleSum) {
		this.saleSum = saleSum;
	}

	public Double getDeductSum() {
		return this.deductSum;
	}

	public void setDeductSum(Double deductSum) {
		this.deductSum = deductSum;
	}

	public Double getSalaryStandardSum() {
		return this.salaryStandardSum;
	}

	public void setSalaryStandardSum(Double salaryStandardSum) {
		this.salaryStandardSum = salaryStandardSum;
	}

	public Double getSalaryPaidSum() {
		return this.salaryPaidSum;
	}

	public void setSalaryPaidSum(Double salaryPaidSum) {
		this.salaryPaidSum = salaryPaidSum;
	}

	@Override
	public String toString() {
		return "SalaryGrantDetailsId [grdId=" + grdId + ", salaryGrantId="
				+ salaryGrantId + ", humanId=" + humanId + ", humanName="
				+ humanName + ", bounsSum=" + bounsSum + ", saleSum=" + saleSum
				+ ", deductSum=" + deductSum + ", salaryStandardSum="
				+ salaryStandardSum + ", salaryPaidSum=" + salaryPaidSum + "]";
	}

	
}