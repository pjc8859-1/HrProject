package cn.storm.service;

import java.util.HashMap;
import java.util.List;

import cn.storm.pojo.EngageResume;

public interface EngageResumeService {
	public boolean addEngageResume(EngageResume engageresume);
	public List<EngageResume> queryAllEngageResume();
	public EngageResume queryEngageResumeByresid(int resid);
	public boolean removeEngageResumeByresid(int resid);
	public int modifyEngageResume(EngageResume engageresume);
	public List<EngageResume> queryByDiction(HashMap<String, Object> map);
}
