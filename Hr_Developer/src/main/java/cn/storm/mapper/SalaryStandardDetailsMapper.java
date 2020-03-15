package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import cn.storm.dto.Xcxm;
import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;

@Repository
public interface SalaryStandardDetailsMapper {

	public boolean saveSalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails);

	public List<SalaryStandardDetails> selectAllSalaryStandardDetails();

	public SalaryStandardDetails selectSalaryStandardDetailsByStd(int std);

	public boolean deleteSalaryStandardDetailsByStd(int std);

	public int updateSalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails);

	public List<Xcxm> querystid(SalaryStandard cstandardid);

	@Delete("delete from salary_standard_details where standard_id=#{standardid}")
	public void deleteByStandardId(String standardid);

	@Insert("insert into salary_standard_details(standard_id,standard_name,item_id"
			+ ",item_name,salary) values(#{standard_id},#{standard_name},#{item_id},#{item_name},#{salary})")
	public void add(Map map);

}
