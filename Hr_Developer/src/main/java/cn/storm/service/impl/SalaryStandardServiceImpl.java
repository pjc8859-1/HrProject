package cn.storm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.SalaryStandardMapper;
import cn.storm.pojo.SalaryStandard;
import cn.storm.service.SalaryStandardService;

@Service
public class SalaryStandardServiceImpl implements SalaryStandardService {
	@Autowired
	SalaryStandardMapper mapper = null;

	@Override
	public boolean addSalaryStandard(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		return mapper.saveSalaryStandard(salaryStandard);
	}

	@Override
	public List<SalaryStandard> queryAllSalaryStandard() {
		// TODO Auto-generated method stub
		return mapper.selectAllSalaryStandard();
	}

	@Override
	public SalaryStandard querySalaryStandardBySsd(String ssd) {
		return mapper.selectSalaryStandardBySd(ssd);
	}

	@Override
	public boolean removeSalaryStandardBySsd(int ssd) {
		// TODO Auto-generated method stub
		return mapper.deleteSalaryStandardBySd(ssd);
	}

	@Override
	public int modifySalaryStandard(SalaryStandard salaryStandard) {
		// TODO Auto-generated method stub
		return mapper.updateSalaryStandard(salaryStandard);
	}

	@Override
	public void updatesa(SalaryStandard sast) {
		mapper.updatesa(sast);
	}

	@Override
	public List<SalaryStandard> queryBySalary(Map map) {
		return mapper.queryBySalary(map);
	}

	@Override
	public void updatechange(SalaryStandard ss) {
		mapper.updatechange(ss);
	}
}
