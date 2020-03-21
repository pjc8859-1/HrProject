package cn.storm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageInterview;

@Repository
public interface EngageInterviewMapper {
	public boolean saveEngageInterview(EngageInterview engageinterview);

	public List<EngageInterview> selectAllEngageInterview();

	public EngageInterview selectEngageInterviewByeinId(int einId);

	public boolean deleteEngageInterviewByeinId(int einId);

	public int updateEngageInterview(EngageInterview engageinterview);
	
	public EngageInterview selectEngageInterviewByeinResumeId(int resumeId);
}
