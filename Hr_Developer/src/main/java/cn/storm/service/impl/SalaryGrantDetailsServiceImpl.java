package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.SalaryGrantDetailsMapper;
import cn.storm.pojo.SalaryGrantDetails;
import cn.storm.pojo.SalaryStandard;
import cn.storm.service.SalaryGrantDetailsService;
@Service
public class SalaryGrantDetailsServiceImpl implements SalaryGrantDetailsService{
	@Autowired
private SalaryGrantDetailsMapper mapper=null;

	@Override
	public boolean addSalaryGrantDetails(SalaryGrantDetails salaryGrantDetails) {
		// TODO Auto-generated method stub
		return mapper.saveSalaryGrantDetails(salaryGrantDetails);
	}

	@Override
	public List<SalaryGrantDetails> queryAllSalaryGrantDetails() {
		// TODO Auto-generated method stub
		return mapper.selectAllSalaryGrantDetails();
	}

	@Override
	public SalaryGrantDetails querySalaryGrantDetailsByGrdId(int grdId) {
		// TODO Auto-generated method stub
		return mapper.selectSalaryGrantDetailsByid(grdId);
	}

	@Override
	public boolean removeSalaryGrantDetailsByGrdId(int grdId) {
		// TODO Auto-generated method stub
		return mapper.deleteSalaryGrantDetailsByid(grdId);
	}

	@Override
	public int modifySalaryGrantDetails(SalaryGrantDetails SalaryGrantDetails) {
		// TODO Auto-generated method stub
		return mapper.updateSalaryGrantDetails(SalaryGrantDetails);
	}
	
}
