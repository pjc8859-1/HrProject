package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageExamMapper;
import cn.storm.pojo.EngageExam;
import cn.storm.service.EngageExamService;

@Service
public class EngageExamServiceImpl implements EngageExamService {

	@Autowired
	 private EngageExamMapper mapper = null;
	
	@Override
	public boolean addEngageExam(EngageExam engageExam) {
		// TODO Auto-generated method stub
		return mapper.saveEngageExam(engageExam);
	}

	@Override
	public List<EngageExam> queryAllEngageExam() {
		// TODO Auto-generated method stub
		return mapper.selectAllEngageExam();
	}

	@Override
	public EngageExam queryEngageExamByexaId(int exaId) {
		// TODO Auto-generated method stub
		return mapper.selectEngageExamByexa_id(exaId);
	}

	@Override
	public boolean removeEngageExamByexaId(int exaId) {
		// TODO Auto-generated method stub
		return mapper.deleteEngageExamByexa_id(exaId);
	}

	@Override
	public int modifyEngageExam(EngageExam engageExam) {
		// TODO Auto-generated method stub
		return mapper.updateEngageExam(engageExam);
	}

}
