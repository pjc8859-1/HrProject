package cn.storm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.dto.Xcxm;
import cn.storm.mapper.SalaryStandardDetailsMapper;
import cn.storm.pojo.SalaryStandard;
import cn.storm.pojo.SalaryStandardDetails;
import cn.storm.service.SalaryStandardDetailsService;

@Service
public class SalaryStandardDetailsServiceImpl implements
		SalaryStandardDetailsService {
	@Autowired
	private SalaryStandardDetailsMapper mapper = null;

	@Override
	public boolean addSalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails) {
		return mapper.saveSalaryStandardDetails(salaryStandardDetails);
	}

	@Override
	public List<SalaryStandardDetails> queryAllSalaryStandardDetails() {
		return mapper.selectAllSalaryStandardDetails();
	}

	@Override
	public SalaryStandardDetails querySalaryStandardDetailsByStd(int std) {
		return mapper.selectSalaryStandardDetailsByStd(std);
	}

	@Override
	public boolean removeSalaryStandardDetailsByStd(int sid) {
		return mapper.deleteSalaryStandardDetailsByStd(sid);
	}

	@Override
	public int modifySalaryStandardDetails(
			SalaryStandardDetails salaryStandardDetails) {
		return mapper.updateSalaryStandardDetails(salaryStandardDetails);
	}

	@Override
	public List<Xcxm> querystid(SalaryStandard cstandardid) {
		return mapper.querystid(cstandardid);
	}

	@Override
	public void deleteByStandardId(String standardid) {
		mapper.deleteByStandardId(standardid);
	}

	@Override
	public void add(Map map) {
		mapper.add(map);
	}
}
