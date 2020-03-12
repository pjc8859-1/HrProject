package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryStandard;
@Repository
public interface SalaryStandardMapper {
	public boolean saveSalaryStandard(SalaryStandard salaryStandard);
	public List<SalaryStandard> selectAllSalaryStandard();
	public SalaryStandard selectSalaryStandardBySd(int ssd);
	public boolean deleteSalaryStandardBySd(int ssd);
	public int updateSalaryStandard(SalaryStandard salaryStandard);
}
