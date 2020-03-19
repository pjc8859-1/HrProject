package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryGrant;

@Repository
public interface SalaryGrantMapper {
	public boolean saveSalaryGrant(SalaryGrant salaryGrant);

	public List<SalaryGrant> selectAllSalaryGrant();

	public SalaryGrant selectSalaryGrantBysgrid(int grdId);

	public boolean deleteSalaryGrantBysgrid(int grdid);

	public int updateSalaryGrant(SalaryGrant SalaryGrant);

	@Select("SELECT SUM(human_amount) as humanall ,SUM(salary_standard_sum) as salaryall,SUM(salary_paid_sum) as salarypall FROM salary_grant")
	public Map SalarySum();

	@Update("update salary_grant set register=#{register},regist_time=#{registTime},check_status=1 where salary_grant_id=#{salaryGrantId}")
	public void updateGrant(SalaryGrant sg);
}
