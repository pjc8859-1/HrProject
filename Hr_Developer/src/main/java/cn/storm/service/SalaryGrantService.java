package cn.storm.service;

import java.util.List;
import java.util.Map;

import cn.storm.pojo.SalaryGrant;

public interface SalaryGrantService {
	public boolean addSalaryGrant(SalaryGrant salaryGrant);

	public List<SalaryGrant> queryAllSalaryGrant();

	public SalaryGrant querySalaryGrantBysgrId(int id);

	public boolean removeSalaryGrantBysgrId(int id);

	public int modifySalaryGrant(SalaryGrant salaryGrant);

	public Map SalarySum();

	public void updateGrant(SalaryGrant sg);

	public void updateCheckGrant(SalaryGrant salarygrant);

	public List<SalaryGrant> queryAllRegisteredSalaryGrant();

	public List<SalaryGrant> queryAllCheckedSalaryGrantBycondition(Map map);

	public Map SalaryRegisteredSum();
}
