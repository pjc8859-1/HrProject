package cn.storm.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageResume;

@Repository
public interface EngageResumeMapper {
	public boolean saveEngageResume(EngageResume engageresume);
	public List<EngageResume> selectAllEngageResume();
	public EngageResume selectEngageResumeByresId(int resId);
	public boolean deleteEngageResumeByresId(int resId);
	public int updateEngageResume(EngageResume engageresume);
	public List<EngageResume> selectByDiction(HashMap<String, Object> map);
}
