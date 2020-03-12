package cn.storm.service;

import java.util.List;

import cn.storm.pojo.MajorChange;
import cn.storm.pojo.SalaryGrant;

public interface SalaryGrantService {
	public boolean addSalaryGrant(SalaryGrant salaryGrant);
	public List<SalaryGrant> queryAllSalaryGrant();
	public SalaryGrant querySalaryGrantBysgrId(int id);
	public boolean removeSalaryGrantBysgrId(int id);
	public int modifySalaryGrant(SalaryGrant salaryGrant);
}
