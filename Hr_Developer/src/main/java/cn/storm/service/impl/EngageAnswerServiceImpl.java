package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageAnswerMapper;
import cn.storm.pojo.EngageAnswer;
import cn.storm.pojo.Users;
import cn.storm.service.EngageAnswerService;

@Service
public class EngageAnswerServiceImpl implements EngageAnswerService {

	@Autowired
	private EngageAnswerMapper mapper = null;

	@Override
	public boolean addEngageAnswer(EngageAnswer engageanswer) {
		return this.mapper.saveEngageAnswer(engageanswer);
	}

	@Override
	public List<EngageAnswer> queryAllEngageAnswer() {
		return this.mapper.selectAllEngageAnswer();
	}

	@Override
	public Users queryEngageAnswerByAnsId(int ansid) {
		return this.mapper.selectEngageAnswerByAnsId(ansid);
	}

	@Override
	public boolean removeEngageAnswerByAnsId(int ansid) {
		return this.mapper.deleteEngageAnswerByAnsId(ansid);
	}

	@Override
	public int modifyEngageAnswer(EngageAnswer engageanswer) {
		return this.mapper.updateEngageAnswer(engageanswer);
	}

}
