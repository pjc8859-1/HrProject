package cn.storm.service;

import java.util.List;

import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;

public interface SalaryStandardService {
	public boolean addSalaryStandard(SalaryStandard salaryStandard);
	public List<SalaryStandard> queryAllSalaryStandard();
	public SalaryStandard querySalaryStandardBySsd(int ssd);
	public boolean removeSalaryStandardBySsd(int ssd);
	public int modifySalaryStandard(SalaryStandard salaryStandard);
}
