package cn.storm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.pojo.Student;
@Repository
public interface SalaryStandardDetailsMapper {

	public boolean saveSalaryStandardDetails(SalaryStandardDetails salaryStandardDetails);
	public List<SalaryStandardDetails> selectAllSalaryStandardDetails();
	public SalaryStandardDetails selectSalaryStandardDetailsByStd(int std);
	public boolean deleteSalaryStandardDetailsByStd(int std);
	public int updateSalaryStandardDetails(SalaryStandardDetails salaryStandardDetails);
}
