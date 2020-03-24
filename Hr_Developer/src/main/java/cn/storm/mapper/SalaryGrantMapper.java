package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
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

	@Select("SELECT SUM(human_amount) as humanall ,SUM(salary_standard_sum) as salaryall,SUM(salary_paid_sum) as salarypall FROM salary_grant where check_status = 0")
	public Map SalarySum();

	@Select("SELECT SUM(human_amount) as humanall ,SUM(salary_standard_sum) as salaryall,SUM(salary_paid_sum) as salarypall FROM salary_grant where check_status = 1")
	public Map SalaryRegisteredSum();

	@Update("update salary_grant set register=#{register},regist_time=#{registTime},check_status=1,salary_paid_sum=#{salaryPaidSum} where salary_grant_id=#{salaryGrantId}")
	public void updateGrant(SalaryGrant sg);

	@Update("update salary_grant set checker=#{checker},check_time=#{checkTime},check_status=2,salary_paid_sum=#{salaryPaidSum}  where salary_grant_id=#{salaryGrantId}")
	public void updateCheckGrant(SalaryGrant salarygrant);

	@Select("Select * from salary_grant where check_status = 1 ")
	@ResultMap("mySalaryGrant")
	public List<SalaryGrant> queryAllRegisteredSalaryGrant();

	public List<SalaryGrant> queryAllCheckedSalaryGrantBycondition(Map map);
}
