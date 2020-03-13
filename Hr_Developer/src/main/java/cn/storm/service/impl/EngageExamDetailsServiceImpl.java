package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageExamDetailsMapper;
import cn.storm.pojo.EngageExamDetails;
import cn.storm.service.EngageExamDetailsService;


@Service
public class EngageExamDetailsServiceImpl implements EngageExamDetailsService {

	@Autowired
	private EngageExamDetailsMapper mapper = null;
	
	@Override
	public boolean addEngageExamDetails(EngageExamDetails engageExamDetails) {
		// TODO Auto-generated method stub
		return mapper.saveEngageExamDetails(engageExamDetails);
	}

	@Override
	public List<EngageExamDetails> queryAllEngageExamDetails() {
		// TODO Auto-generated method stub
		return mapper.selectAllEngageExamDetails();
	}

	@Override
	public EngageExamDetails queryEngageExamDetailsByexdId(int exdId) {
		// TODO Auto-generated method stub
		return mapper.selectEngageExamDetailsByexd_id(exdId);
	}

	@Override
	public boolean removeEngageExamDetailsByexdId(int exdId) {
		// TODO Auto-generated method stub
		return mapper.deleteEngageExamDetailsByexd_id(exdId);
	}

	@Override
	public int modifyEngageExamDetails(EngageExamDetails engageExamDetails) {
		// TODO Auto-generated method stub
		return mapper.updateEngageExamDetails(engageExamDetails);
	}

}
