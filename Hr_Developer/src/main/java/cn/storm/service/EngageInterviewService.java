package cn.storm.service;

import java.util.List;

import cn.storm.pojo.EngageInterview;

public interface EngageInterviewService {
	public boolean addEngageInterview(EngageInterview engageinterview);

	public List<EngageInterview> queryAllEngageInterview();

	public EngageInterview queryEngageInterviewByeinId(int einId);

	public boolean removeEngageInterviewByeinId(int einId);

	public int modifyEngageInterview(EngageInterview engageinterview);
}
