package cn.storm.service;

import java.util.List;

import cn.storm.pojo.SalaryStandard;

public interface SalaryStandardService {
	public boolean addSalaryStandard(SalaryStandard salaryStandard);

	public List<SalaryStandard> queryAllSalaryStandard();

	public SalaryStandard querySalaryStandardBySsd(String ssd);

	public boolean removeSalaryStandardBySsd(int ssd);

	public int modifySalaryStandard(SalaryStandard salaryStandard);

	public void updatesa(SalaryStandard sast);
}
