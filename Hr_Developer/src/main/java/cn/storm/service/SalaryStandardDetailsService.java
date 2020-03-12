package cn.storm.service;

import java.util.List;

import cn.storm.pojo.SalaryStandardDetails;

public interface SalaryStandardDetailsService {
	public boolean addSalaryStandardDetails(SalaryStandardDetails salaryStandardDetails);
	public List<SalaryStandardDetails> queryAllSalaryStandardDetails();
	public SalaryStandardDetails querySalaryStandardDetailsByStd(int std);
	public boolean removeSalaryStandardDetailsByStd(int sid);
	public int modifySalaryStandardDetails(SalaryStandardDetails salaryStandardDetails);

}
