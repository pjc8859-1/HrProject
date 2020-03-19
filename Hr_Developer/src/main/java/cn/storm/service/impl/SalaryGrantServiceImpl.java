package cn.storm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.SalaryGrantMapper;
import cn.storm.pojo.SalaryGrant;
import cn.storm.service.SalaryGrantService;

@Service
public class SalaryGrantServiceImpl implements SalaryGrantService {
	@Autowired
	private SalaryGrantMapper mapper = null;

	@Override
	public boolean addSalaryGrant(SalaryGrant salaryGrant) {
		// TODO Auto-generated method stub
		return mapper.saveSalaryGrant(salaryGrant);
	}

	@Override
	public List<SalaryGrant> queryAllSalaryGrant() {
		// TODO Auto-generated method stub
		return mapper.selectAllSalaryGrant();
	}

	@Override
	public SalaryGrant querySalaryGrantBysgrId(int id) {
		// TODO Auto-generated method stub
		return mapper.selectSalaryGrantBysgrid(id);
	}

	@Override
	public boolean removeSalaryGrantBysgrId(int id) {
		// TODO Auto-generated method stub
		return mapper.deleteSalaryGrantBysgrid(id);
	}

	@Override
	public int modifySalaryGrant(SalaryGrant salaryGrant) {
		// TODO Auto-generated method stub
		return mapper.updateSalaryGrant(salaryGrant);
	}

	@Override
	public Map SalarySum() {
		return mapper.SalarySum();
	}

	@Override
	public void updateGrant(SalaryGrant sg) {
		mapper.updateGrant(sg);
	}

	@Override
	public List<SalaryGrant> queryAllRegisteredSalaryGrant() {
		return mapper.queryAllRegisteredSalaryGrant();
	}

	@Override
	public Map SalaryRegisteredSum() {
		return mapper.SalaryRegisteredSum();
	}

	@Override
	public void updateCheckGrant(SalaryGrant salarygrant) {
		mapper.updateCheckGrant(salarygrant);
	}

	@Override
	public List<SalaryGrant> queryAllCheckedSalaryGrantBycondition(Map map) {
		return mapper.queryAllCheckedSalaryGrantBycondition(map);
	}
}
