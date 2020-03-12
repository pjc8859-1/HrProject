package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageInterviewMapper;
import cn.storm.pojo.EngageInterview;
import cn.storm.service.EngageInterviewService;

@Service
public class EngageInterviewServiceImpl implements EngageInterviewService {
	@Autowired
	private EngageInterviewMapper mapper = null;

	@Override
	public boolean addEngageInterview(EngageInterview engageinterview) {
		return mapper.saveEngageInterview(engageinterview);
	}

	@Override
	public List<EngageInterview> queryAllEngageInterview() {
		return mapper.selectAllEngageInterview();
	}

	@Override
	public EngageInterview queryEngageInterviewByeinId(int einId) {
		return mapper.selectEngageInterviewByeinId(einId);
	}

	@Override
	public boolean removeEngageInterviewByeinId(int einId) {
		return mapper.deleteEngageInterviewByeinId(einId);
	}

	@Override
	public int modifyEngageInterview(EngageInterview engageinterview) {
		return mapper.updateEngageInterview(engageinterview);
	}
}
