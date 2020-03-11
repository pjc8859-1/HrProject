package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.SalaryStandardDetailsMapper;
import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.pojo.Student;
import cn.storm.service.SalaryStandardDetailsService;

@Service
public class SalaryStandardDetailsServiceImpl implements SalaryStandardDetailsService{
	@Autowired
private  SalaryStandardDetailsMapper mapper=null;
	@Override
	public boolean addSalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails) {
		// TODO Auto-generated method stub
		return mapper.saveSalaryStandardDetails(salaryStandardDetails);
	}

	@Override
	public List<SalaryStandardDetails> queryAllSalaryStandardDetails() {
		// TODO Auto-generated method stub
		return mapper.selectAllSalaryStandardDetails();
	}

	@Override
	public SalaryStandardDetails querySalaryStandardDetailsByStd(int std) {
		// TODO Auto-generated method stub
		return mapper.selectSalaryStandardDetailsByStd(std);
	}

	@Override
	public boolean removeSalaryStandardDetailsByStd(int sid) {
		// TODO Auto-generated method stub
		return mapper.deleteSalaryStandardDetailsByStd(sid);
	}

	@Override
	public int modifySalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails) {
		// TODO Auto-generated method stub
		return mapper.updateSalaryStandardDetails(salaryStandardDetails);
	}

}
