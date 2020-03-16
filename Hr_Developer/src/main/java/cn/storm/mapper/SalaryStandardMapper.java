package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryStandard;

@Repository
public interface SalaryStandardMapper {
	public boolean saveSalaryStandard(SalaryStandard salaryStandard);

	public List<SalaryStandard> selectAllSalaryStandard();

	public SalaryStandard selectSalaryStandardBySd(String ssd);

	public boolean deleteSalaryStandardBySd(int ssd);

	public int updateSalaryStandard(SalaryStandard salaryStandard);

	@Update("update Salary_standard set standard_name=#{standardName},checker=#{checker},check_comment=#{checkComment},"
			+ "check_status=1,check_time=#{checkTime},salary_sum=#{salarySum} where standard_id=#{standardId}")
	public void updatesa(SalaryStandard sast);

	public List<SalaryStandard> queryBySalary(Map map);
}
