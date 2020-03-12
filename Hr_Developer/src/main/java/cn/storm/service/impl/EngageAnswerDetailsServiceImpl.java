package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageAnswerDetailsMapper;
import cn.storm.pojo.EngageAnswerDetails;
import cn.storm.service.EngageAnswerDetailsService;

@Service
public class EngageAnswerDetailsServiceImpl implements EngageAnswerDetailsService{
	@Autowired
	private EngageAnswerDetailsMapper mapper = null;
	
	
	@Override
	public boolean addEngageAnswerDetails(
			EngageAnswerDetails engageanswerdetails) {
		return this.mapper.saveEngageAnswerDetails(engageanswerdetails);
	}

	@Override
	public List<EngageAnswerDetails> queryAllEngageAnswerDetails() {
		return this.mapper.selectAllEngageAnswerDetails();
	}

	@Override
	public EngageAnswerDetails queryEngageAnswerDetailsByansid(int ansid) {
		return this.mapper.selectEngageAnswerDetailsByAnsId(ansid);
	}

	@Override
	public boolean removeEngageAnswerDetailsByansid(int ansid) {
		return this.mapper.deleteEngageAnswerDetailsByAnsId(ansid);
	}

	@Override
	public int modifyEngageAnswerDetails(EngageAnswerDetails engageanswerdetails) {
		return this.mapper.updateEngageAnswerDetails(engageanswerdetails);
	}

}
