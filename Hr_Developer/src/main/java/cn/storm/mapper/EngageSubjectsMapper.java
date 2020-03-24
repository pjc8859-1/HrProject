package cn.storm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.storm.pojo.EngageSubjects;
@Repository
public interface EngageSubjectsMapper {
	public boolean saveEngageSubjects(EngageSubjects engagesubjects);

	public List<EngageSubjects> selectAllEngageSubjects();

	public EngageSubjects selectEngageSubjectsBysubId(int subid);

	public boolean deleteEngageSubjectsBysubId(int subid);

	public int updateEngageSubjects(EngageSubjects engagesubjects);
	
	public List<EngageSubjects> selectEngageSubjectsByCondition(Map<String, Object> map);
}
