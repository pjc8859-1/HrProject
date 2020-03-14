package cn.storm.service;

import java.util.List;
import java.util.Map;

import cn.storm.dto.Xcxm;
import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;

public interface SalaryStandardDetailsService {
	public boolean addSalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails);

	public List<SalaryStandardDetails> queryAllSalaryStandardDetails();

	public SalaryStandardDetails querySalaryStandardDetailsByStd(int std);

	public boolean removeSalaryStandardDetailsByStd(int sid);

	public int modifySalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails);

	public List<Xcxm> querystid(SalaryStandard cstandardid);

	public void deleteByStandardId(String standardid);

	public void add(Map map);

}
