package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryGrantDetails;

@Repository
public interface SalaryGrantDetailsMapper {
	public boolean saveSalaryGrantDetails(SalaryGrantDetails salaryGrantDetails);

	public List<SalaryGrantDetails> selectAllSalaryGrantDetails();

	public SalaryGrantDetails selectSalaryGrantDetailsByid(int grdId);

	public boolean deleteSalaryGrantDetailsByid(int grdid);

	public int updateSalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails);

	public List<SalaryGrantDetails> Bysalary_grant_id(int sgid);

	@Select("SELECT SUM(salary_standard_sum) as salaryall,SUM(salary_paid_sum) as salarypall FROM salary_grant_details WHERE salary_grant_id=#{sid}")
	@ResultMap("SUMmap")
	public Map SalarySumByid(int sid);

	@Update("update salary_grant_details set bouns_sum=#{bounsSum},sale_sum=#{saleSum},deduct_sum=#{deductSum},salary_paid_sum=#{salaryPaidSum}"
			+ " where salary_grant_id=#{sid} and human_id=#{humanId} and human_name=#{humanName}")
	public void add(Map map);

}
