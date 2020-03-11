package cn.storm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "hr")
public class Student implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String SName;
	private String SEx;
	private Integer SCore;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String SName) {
		this.SName = SName;
	}

	/** full constructor */
	public Student(String SName, String SEx, Integer SCore) {
		this.SName = SName;
		this.SEx = SEx;
		this.SCore = SCore;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "s_id", unique = true, nullable = false)
	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	@Column(name = "s_name", nullable = false, length = 10)
	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	@Column(name = "s_ex", length = 2)
	public String getSEx() {
		return this.SEx;
	}

	public void setSEx(String SEx) {
		this.SEx = SEx;
	}

	@Column(name = "s_core")
	public Integer getSCore() {
		return this.SCore;
	}

	public void setSCore(Integer SCore) {
		this.SCore = SCore;
	}

}