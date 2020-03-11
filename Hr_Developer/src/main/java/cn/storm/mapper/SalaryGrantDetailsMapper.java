package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryGrantDetails;
import cn.storm.pojo.SalaryStandardDetails;
@Repository
public interface SalaryGrantDetailsMapper {
	public boolean saveSalaryGrantDetails(SalaryGrantDetails salaryGrantDetails);
	public List<SalaryGrantDetails> selectAllSalaryGrantDetails();
	public SalaryGrantDetails selectSalaryGrantDetailsByid(int grdId);
	public boolean deleteSalaryGrantDetailsByid(int grdid);
	public int updateSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails);
}
