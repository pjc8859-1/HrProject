package cn.storm.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageResumeMapper;
import cn.storm.pojo.EngageResume;
import cn.storm.service.EngageResumeService;
@Service
public class EngageResumeServiceImpl implements EngageResumeService{
	@Autowired
	private EngageResumeMapper mapper=null;

	@Override
	public boolean addEngageResume(EngageResume engageresume) {
		return this.mapper.saveEngageResume(engageresume);
	}

	@Override
	public List<EngageResume> queryAllEngageResume() {
		return this.mapper.selectAllEngageResume();
	}

	@Override
	public EngageResume queryEngageResumeByresid(int resid) {
		return this.mapper.selectEngageResumeByresId(resid);
	}

	@Override
	public boolean removeEngageResumeByresid(int resid) {
		return this.mapper.deleteEngageResumeByresId(resid);
	}

	@Override
	public int modifyEngageResume(EngageResume engageresume) {
		return this.mapper.updateEngageResume(engageresume);
	}

	@Override
	public List<EngageResume> queryByDiction(HashMap<String, Object> map) {
		
		return this.mapper.selectByDiction(map);
	}

}
