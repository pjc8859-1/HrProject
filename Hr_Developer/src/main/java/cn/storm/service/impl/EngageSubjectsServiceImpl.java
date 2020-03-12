package cn.storm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.storm.mapper.EngageSubjectsMapper;
import cn.storm.pojo.EngageSubjects;
import cn.storm.service.EngageSubjectsService;
@Service
public class EngageSubjectsServiceImpl implements EngageSubjectsService {
	@Autowired
	private EngageSubjectsMapper mapper = null;
	
	@Override
	public boolean addEngageSubjects(EngageSubjects engagesubjects) {
		// TODO Auto-generated method stub
		return this.mapper.saveEngageSubjects(engagesubjects);
	}

	@Override
	public List<EngageSubjects> queryAllEngageSubjects() {
		// TODO Auto-generated method stub
		return this.mapper.selectAllEngageSubjects();
	}

	@Override
	public EngageSubjects queryEngageSubjectssubId(int subid) {
		// TODO Auto-generated method stub
		return this.mapper.selectEngageSubjectsBysubId(subid);
	}

	@Override
	public boolean removeEngageSubjectsBysubId(int subid) {
		// TODO Auto-generated method stub
		return this.mapper.deleteEngageSubjectsBysubId(subid);
	}

	@Override
	public int modifyEngageSubjects(EngageSubjects engagesubjects) {
		// TODO Auto-generated method stub
		return this.mapper.updateEngageSubjects(engagesubjects);
	}

}
