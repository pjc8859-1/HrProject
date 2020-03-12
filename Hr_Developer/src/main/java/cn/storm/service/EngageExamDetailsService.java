package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageExamDetails;

public interface EngageExamDetailsService {

	
	public boolean addEngageExamDetails(EngageExamDetails engageExamDetails);

	public List<EngageExamDetails> queryAllEngageExamDetails();

	public EngageExamDetails queryEngageExamDetailsByexdId(int exdId);

	public boolean removeEngageExamDetailsByexdId(int exdId);

	public int modifyEngageExamDetails(EngageExamDetails engageExamDetails);
}
