package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageAnswerDetails;

public interface EngageAnswerDetailsService {
	public boolean addEngageAnswerDetails(EngageAnswerDetails engageanswerdetails);

	public List<EngageAnswerDetails> queryAllEngageAnswerDetails();

	public EngageAnswerDetails queryEngageAnswerDetailsByansid(int ansid);

	public boolean removeEngageAnswerDetailsByansid(int ansid);

	public int modifyEngageAnswerDetails(EngageAnswerDetails engageanswerdetails);
}
