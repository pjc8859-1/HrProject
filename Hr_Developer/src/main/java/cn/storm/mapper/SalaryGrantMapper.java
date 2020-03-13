package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryGrant;
import cn.storm.pojo.SalaryGrantDetails;
@Repository
public interface SalaryGrantMapper {
	public boolean saveSalaryGrant(SalaryGrant salaryGrant);
	public List<SalaryGrant> selectAllSalaryGrant();
	public SalaryGrant selectSalaryGrantBysgrid(int grdId);
	public boolean deleteSalaryGrantBysgrid(int grdid);
	public int updateSalaryGrant(SalaryGrant SalaryGrant);

}
