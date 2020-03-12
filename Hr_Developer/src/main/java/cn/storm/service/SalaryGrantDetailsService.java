package cn.storm.service;

import java.util.List;

import cn.storm.pojo.SalaryGrantDetails;

public interface SalaryGrantDetailsService {
	public boolean addSalaryGrantDetails(SalaryGrantDetails salaryGrantDetails);
	public List<SalaryGrantDetails> queryAllSalaryGrantDetails();
	public SalaryGrantDetails querySalaryGrantDetailsByGrdId(int grdId);
	public boolean removeSalaryGrantDetailsByGrdId(int grdId);
	public int modifySalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails);
}
