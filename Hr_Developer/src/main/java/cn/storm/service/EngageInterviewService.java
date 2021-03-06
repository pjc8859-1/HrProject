package cn.storm.service;

import java.util.HashMap;
import java.util.List;

import cn.storm.pojo.EngageInterview;

public interface EngageInterviewService {
	public boolean addEngageInterview(EngageInterview engageinterview);

	public List<EngageInterview> queryAllEngageInterview();

	public EngageInterview queryEngageInterviewByeinId(int einId);

	public boolean removeEngageInterviewByeinId(int einId);

	public int modifyEngageInterview(EngageInterview engageinterview);
	
	public EngageInterview queryEngageInterviewByeinResumeId(int resumeId);
	
	public List<EngageInterview> queryByDiction(HashMap<String, Object> map);
}
